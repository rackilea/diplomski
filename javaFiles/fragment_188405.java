try {

/*Getting the connection variable from session*/

con=(Connection)session.getAttribute("connection");
stmt =  con.createStatement();

String Query = "SELECT * from student where studentid = \'"+disluserid+"\'";
System.out.println(Query);
rs = stmt.executeQuery(Query);
} catch(Exception e) { System.out.println("Exception"+e);