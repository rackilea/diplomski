import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.Reader;
 import java.io.StringReader;
 import java.security.GeneralSecurityException;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.ArrayList;
 import java.util.List;


 public class ClobBatch {

    public static void main(String[] args) throws GeneralSecurityException, IOException, SQLException {

        String databaseCredentials = ExternalData.getCredentials();
        Connection c1=DriverManager.getConnection(databaseCredentials);
        Connection c2=DriverManager.getConnection(databaseCredentials);

        String sql="create volatile table clob_test_input ( id bigint, longobj clob) no primary index on commit preserve rows;";
        Statement s=c1.createStatement();
        s.execute(sql);

        String sql2="create volatile table clob_test_target ( id bigint, longobj clob) no primary index on commit preserve rows;";
        Statement s2=c2.createStatement();
        s2.execute(sql2);

        System.out.println("Inserting test data");
        PreparedStatement ps=c1.prepareStatement("insert into clob_test_input (id, longobj) values (?,?);"); 
        for(int i=0; i<1000; i++) {
            String st=randomLargeString();
            ps.setInt(1, i);
            ps.setCharacterStream(2, new BufferedReader(new StringReader(st)), st.length());
            ps.addBatch();
        }
        ps.executeBatch();

        System.out.println("reading test data from input table");
        Statement select=c1.createStatement();
        ResultSet rs=select.executeQuery("select * from clob_test_input");


        PreparedStatement ps2=c2.prepareStatement("insert into clob_test_target (id, longobj) values (?,?);"); 
        List<Reader> readerToClose=new ArrayList<Reader>(); 
        System.out.println("start batch creation");
        while(rs.next()) {
            int pos=rs.getInt("id");
            Reader rdr=new BufferedReader(rs.getCharacterStream("longobj"));

            StringBuffer buffer=new StringBuffer();
            int c=0;
            while((c=rdr.read())!=-1) {
                buffer.append((char)c);
            }
            rdr.close();
            ps2.setInt(1, pos);
            Reader strReader= new StringReader(buffer.toString());
            ps2.setCharacterStream(2, strReader,buffer.length());
            readerToClose.add(strReader);
            ps2.addBatch();
        }
        System.out.println("start batch execution");
        ps2.executeBatch();
        rs.close();
        c1.commit();
        c2.commit();

        for(Reader r:readerToClose) r.close();

        Statement selectTest=c2.createStatement();
        ResultSet rsTest=selectTest.executeQuery("select * from clob_test_target");
        System.out.println("show results");
        int i=0;
        while(rsTest.next()) {
            BufferedReader is=new BufferedReader(rsTest.getCharacterStream("longobj"));
            StringBuilder sb=new StringBuilder();
            int c=0;
            while((c=is.read())!=-1) {
                sb.append((char)c);
            }
            is.close();
            System.out.println(""+rsTest.getInt("id")+' '+sb.toString().substring(0,80));
        }

        rsTest.close();
    }


    private static String randomLargeString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10000; i++) {
            sb.append((char) (64+Math.random()*20));
        }
        return sb.toString();
    }
 }