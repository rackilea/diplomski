try{
        int flag=0;
        PreparedStatement ps=null;
        Connection con= null;
        ResultSet rs= null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("hostname","user","admin");
        Statement st=con.createStatement();

        String id = request.getParameter("id");  
        String name= request.getParameter("name");

        // Check if the "id" is already present in table or not
        rs = st.executeQuery("SELECT * FROM employee WHERE employeeid" = id );   
        if (!rs.next() ) {

            // id is not present then insert the new record
            rs = st.executeQuery("INSERT INTO employee (employeeid,employeename)VALUES ('"+id+"','"+name+""); 
            System.out.println("Data is successfully inserted!");

        } else{

            // id is already present then show the error message
            System.out.println("Data is already present in table!");
        }

} catch(Exception e){

    // Handle any other exception occuring 
    System.out.println("Exception : " + e.printStackTrace());
}