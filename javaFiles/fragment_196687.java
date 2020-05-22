boolean ready = target.hasReqArtifacts( reqStones, reqPotions, reqWands, reqWeapons );
//checks to see if creature already has correct amount of each item.
//If it does it should skip pool interaction until it dumps its used items
//back into the pool.
System.out.println( "Ready: " + ready );
while ( !ready ) {
    // begin pool interaction
    synchronized (target.poolParty) {
        target.pickUpArtifacts( reqStones, reqPotions, reqWands, reqWeapons );
        ready = target.hasReqArtifacts( reqStones, reqPotions, reqWands, reqWeapons );

        /* I'd move this here. If we never release out items then the
           other party members can't use them while this one still does
           not have the needed items. Now they will be available to
           other parties while this thread sleeps. */
        if (!ready) {
            // adds all artifacts held by creature to an arraylist in poolParty
            target.releaseArtifacts();
        }
    }

    // These don't access the pool, so they can be outside the synchronized block
    if ( ready ) {
        System.out.println( "has required Items" );
    } else {
        System.out.println( "Does not have required Items" );
        // Sleep before the next try to get the required items. Lets other
        // threads attempt to fetch their needed items
        try {
            Thread.sleep( 1000 );
        } catch ( InterruptedException e ) {
            // Added, because silently eating exceptions is a bad idea
            e.printStackTrace();
        }
    }
}//end pool interaction