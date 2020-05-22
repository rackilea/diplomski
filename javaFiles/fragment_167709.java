public Cursor fetchAllMessages(){
    String query = "SELECT " + MESSAGE_TABLE + "." + MessageContract._ID + ", "
            + MessageContract.MESSAGE_TEXT + ", "
            + PeerContract.NAME + ", "
            + PeerContract.MESSAGE_TEXT + ", "
            + MessageContract.SENDER 
            + " FROM " + MESSAGE_TABLE + " JOIN " + PEER_TABLE + " ON "
            + MESSAGE_TABLE + "." + MessageContract.PEER_FOREIGN_KEY
            + "=" + PEER_TABLE + "." + PeerContract._ID;
    return db.rawQuery(query, null);
}