public boolean changePassword(String password, String id) {

    try {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, DBuser, DBpassword);


        Statement st = conn.createStatement();
        String updateQuery = "update teacher_registration set password="+password+" where teacher_id="+id;
        ResultSet rs = st.executeQuery(updateQuery);
        if(rs!=null){
            return true;
        }

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

}