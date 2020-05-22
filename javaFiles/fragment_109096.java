try{
    ResultSet resuse = DoQuery("SELECT KEY FROM TABLE WHERE KEY IN ('KEY1', 'KEY2') AND ROWNUM = 1");
    resuse.next();
    variable = resuse.getString("KEY");
}catch(SQLException e){
    return "Wasn't able to gather key: " + e.toString() + " - " + e.getSQLState();
}