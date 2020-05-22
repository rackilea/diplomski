String sql = "{ ? = call FUNCT_PERSON(?,?) }";
CallableStatement statement = connection.prepareCall(sql);
statement.setString(2,username);
statement.setString(3,password);
statement.registerOutParameter(1, java.sql.Types.INTEGER);  

statement.execute();   
//this is the main line
long id = statement.getLong(1);
if (id > 0) {
    //proceed to another page
} else {
    //Go back to the login page
}