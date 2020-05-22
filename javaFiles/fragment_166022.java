public static void displayMaxSalary() throws ClassNotFoundException, SQLException

{   

    String maxSalary;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/task4DB?"
              + "user=root&password=123");
    PreparedStatement st = con.prepareStatement("select * from task4Table order by salary desc limit 1");
    ResultSet r1=st.executeQuery();

     if(r1.next()) {

           maxSalary =  r1.getString("fName")+""+r1.getString("lName");
      }

     System.out.println("The name of employee who has the higher salary is :");
     System.out.println( maxSalary);


} //end-displayMaxSalary.