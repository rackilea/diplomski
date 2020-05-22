for(i=0, i < dblist.size(); i++
{
    dblist.get(i);
    //Separate the string you got from the ArrayList into host, user, pass and assign correct variables
    Class.forName("com.mysql.jdbc.Driver");
    //Variables you got from the list go in the next statement
    Connection c = DriverManager.getConnection("jdbc:mysql://"+host+"/" + db +"?user="+user+"&password="+password);
}