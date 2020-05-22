while (rs.next()) {
    int id = rs.getInt("id");
    String text = rs.getString("text");
    if(text == null)
        text = "";
    updatepage.setString(1, text);
    updatepage.setInt(2, id);

    //add the current statement to the batch
    updatepage.addBatch();
    if(count++ > 10000) {
        //line below will only execute the current statement (useless)
        //updatepage.executeUpdate();
        //line below will clear the batch statements (useless too)
        //updatepage.clearBatch();
        updatepage.executeBatch();
        count = 0;
    }
}
//updatepage.executeUpdate();
updatepage.executeBatch();