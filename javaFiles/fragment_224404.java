public void printTheNames(String sqlQuery)
{
    ResultSet infoDump = stmt.executeQuery(sqlQuery);
    String actID = null;
    while (infoDump.next()){
        actID = infoDump.getString("Name");
        System.out.println(actID);
    }
}