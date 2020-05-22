final Connection conn = connection;

ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
    exec.scheduleAtFixedRate(new Runnable(){
        @Override
        public void run(){
            System.out.println("Working ... ");
            String sql = "SELECT * FROM table;";
            Statement st;
            try {
                st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
    }, 2000, 1000, TimeUnit.MILLISECONDS);