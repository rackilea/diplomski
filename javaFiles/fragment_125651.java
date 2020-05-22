public class SelectThreadClass implements Callable<List<String>> {

    public List<String> call(){
        ResultSet rs = null;
        List<String> strList = new ArrayList<String>();
        try {
            rs  = perform();
            while(rs.next()){
                strList.add(rs.getString("EMPNAME"));
            }
            System.out.println("Passed");

        } catch (InstantiationException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
        return strList;
    }

    public ResultSet perform() throws InstantiationException, IllegalAccessException, SQLException{
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:C:\\SqlLite\\EMPLOYEE.db");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            Statement s = null;
            try {
                s = conn.createStatement();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ResultSet rs = null;
            try {
                rs = s.executeQuery(Utils.selectQuery);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return rs;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}