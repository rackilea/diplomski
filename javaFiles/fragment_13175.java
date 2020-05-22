public void updateRank(Map<Integer,Double> map){
    Iterator<Entry<Integer, Double>> it = map.entrySet().iterator();
    String query = "";
    int i = 0;

    Connection connection = getConnection(); // get the DB connection from somewhere
    PreparedStatement stmt = connection.prepareStatement("update profile set rank = ? where profileId = ?");

    while (it.hasNext()) {
        Map.Entry<Integer,Double> pairs = (Map.Entry<Integer,Double>)it.next();
        stmt.setInt(1, pairs.getValue());
        stmt.setDouble(2, pairs.getKey());
        stmt.addBatch(); // this will just collect the data values
        it.remove();
    }       
    stmt.executeBatch(); // this will actually execute the updates all in one
}