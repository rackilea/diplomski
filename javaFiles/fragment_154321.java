private static ArrayList returnObjectArray()throws Exception {
     String connnectionURL = "jdbc:sqlserver://localhost\\FAISAL-FAS:1433;username=sa;password=password";

        ArrayList<Object> data = new ArrayList();

     try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection(connnectionURL);
         ResultSet rs = conn.getMetaData().getSchemas();

         while(rs.next()) {
             data.add(rs.getObject(1));
         }
     }
     catch(Exception e){
         e.printStackTrace();
     }
     return data;
}


public static void main (String[] args) {
    for(Object checkers: returnObjectArray()){
        System.out.println(checkers);
    }
}