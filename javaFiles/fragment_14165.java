class ThreadTask implements Runnable {
     private Connection connection;

     public ThreadTask(Connection c) {
          connection = c;
     }

     @Override
     public void run() {
        System.out.println("Working ... ");
        String sql = "SELECT * FROM table;";
        Statement st;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
}