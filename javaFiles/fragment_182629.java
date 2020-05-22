btnInsert.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseDown(MouseEvent e) {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           try (Connection connect = DriverManager.getConnection(...);
                Statement statement = connect.createStatement()) {

                // execute the statement here

           } catch (SQLException ex) {
               ex.printStackTrace();
           }

       } catch (ClassNotFoundException ex) {
           e.printStackTrace();
       }
});