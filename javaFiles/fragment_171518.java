import java.sql.*;

public class Match {
    public static void main(String args[]) throws Exception{
        DBConnection1 con = new DBConnection1();
        DBConnection con1 = new DBConnection();
        Connection conn = null,conn1=null;
        conn = con.getConnection();
        conn1 = con1.getConnection();
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rs = null,rs1 = null;
        st = conn.createStatement();
        st.setFetchSize(Integer.MIN_VALUE);
        String query = "SELECT name FROM emp";
        rs = st.executeQuery(query);
        String title = "",query1="";
        StringBuffer newQuery = new StringBuffer("SELECT Name FROM Employee WHERE ");
        int count = 0;
        long nameCount = 0L;
        while(rs.next()){
            nameCount++;
            title = rs.getString("name");
            query1 = "Name=? or";
            pst = conn1.prepareStatement(query1);
            pst.setString(1, title);

            newQuery.append(pst.toString().substring(pst.toString().indexOf('N'), pst.toString().length())+" ");
        }

        if ( nameCount > 0 ){
            String Query = newQuery.toString().substring(0,newQuery.toString().length() - 3);  
            rs1 = conn1.createStatement().executeQuery(Query);
            while(rs1.next()){
                count++;
                if(count % 50 == 0)
                    System.out.println(count);
            }
        }
    }
}