...
htPeerPhaser.register(); // Called only once.
...
// Note: Server application has guaranteed that no more than the maximum number of peers will arrive.
try {
    logger.INFO("CONNECTED - Peer ID properties: " + SYS_NEWLINE + peerSocket + SYS_NEWLINE + pID, true);
    final int peerKQueries = sp.getInteger(peerSocket);
    peerObjects = new String[peerKQueries];
    peerValues = new BigDecimal[peerKQueries];
    for ( int i = 0; i < peerObjects.length; i++ )
        peerObjects[i] = sp.getString(peerSocket);
    for ( int i = 0; i < peerValues.length; i++ )
        peerValues[i] = sp.getBigDecimal(peerSocket);
    final int registrationID = htPeerPhaser.bulkRegister(1);
    if ( registrationID < 0 ) {
        logger.ERROR("Rejecting Super Peer thread " + THREAD_ID + " because peer registration has stopped!", true);
        sp.close(peerSocket);
        throw new IllegalThreadStateException();
    }
    logger.INFO(pID + " -> Registered for HT phase 1.", true);
    logger.INFO("Super Peer thread " + THREAD_ID + " will advance to HT Phase 1/2.", true);
    // The last peer should also unblock the barrier.
    if ( htPeerPhaser.getRegisteredParties() == TOTAL_PEERS.get()+1 ) {
        htPeerPhaser.forceTermination();
        PEER.countDown();
    }
    htPeerPhaser.awaitAdvanceInterruptibly(registrationID, 30, TimeUnit.SECONDS);

} catch (IOException e) {
    logger.ERROR("Super Peer thread " + THREAD_ID + " encountered an I/O error.", true);
    sp.close(peerSocket);
    throw new IllegalThreadStateException();
} catch (TimeoutException e) {
    htPeerPhaser.forceTermination();
    logger.INFO("Super Peer thread " + THREAD_ID + " timed out but will advance to HT Phase 1b/2.", true);
    if ( HAS_TIMED_OUT.compareAndSet(false, true) && htPeerPhaser.getRegisteredParties() < TOTAL_PEERS.get()+1 ) {
        final int arrivedPeers = htPeerPhaser.getRegisteredParties()-1;
        logger.INFO("Parties that arrived before timeout: "+arrivedPeers, true);
        final int unarrivedPeers = TOTAL_PEERS.get()-arrivedPeers;
        logger.INFO("Parties NOT arrived due to timeout: "+unarrivedPeers, true);
        resetCriticalData(arrivedPeers);
        instantiateHTPhase1b();
        instantiateHTPhase2();
        instantiateHTPatch();
        PEER.countDown();
        logger.INFO("Super Peer thread " + THREAD_ID + " re-instantiated critical data.", true);
    }
}
logger.INFO("Super Peer thread "+THREAD_ID+" is blocked!", true);
PEER.await();
logger.INFO("Super Peer thread's "+THREAD_ID+" blocking waived!", true);