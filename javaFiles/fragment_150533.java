import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCopy {

    public static void main(String[] args) {

        try {
            //You know how to do this - just rename and copy in...
            Connection sourceCon = getOracleConnection(); 
            Connection targetCon = geSqlServerConnection();

            copyMaterialBatch(sourceCon, targetCon);
            copyMaterialMaster(sourceCon, targetCon);
            copyVendor(sourceCon, targetCon);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void copyMaterialBatch(Connection sourceCon, Connection targetCon) throws SQLException {
        //Try-with-Resource to close all cursors once we're done
        try(//SELECT from source
                PreparedStatement ps = sourceCon.prepareStatement(
                    "SELECT \"MATERIAL NUMBER\", "
                    + "\"BATCH NUMBER\", "
                    + "\"VENDOR BATCH NUMBER\", "
                    + "\"VENDOR NUMBER\", "
                    + "\"EXPIRATION DATE\", "
                    + "\"MODIFIED_DATETIME\" FROM MATERIAL_BATCH");
            //INSERT into target
                PreparedStatement ins = targetCon.prepareStatement(
                        "INSERT INTO MATERIAL_BATCH([MATERIAL NUMBER], "
                    + "[BATCH NUMBER], "
                    + "[VENDOR BATCH NUMBER], "
                    + "[VENDOR NUMBER], "
                    + "[GOODS_SUPPLIER_NUMBER], "
                    + "[EXPIRATION DATE]"
                    + "[INSTIME]) VALUES (?,?,?,?,NULL,?,?)");
            //Perform select / open Cursor
                ResultSet rs = ps.executeQuery()) {
            int batchnr = 0;
            int MAXBATCH = 100;
            while(rs.next()) {
                //Set into INSERT the values we SELECTEd
                ins.setInt(1, rs.getInt("MATERIAL NUMBER")); 
                ins.setInt(2, rs.getInt("BATCH NUMBER")); 
                ins.setInt(3, rs.getInt("VENDOR BATCH NUMBER")); 
                ins.setInt(4, rs.getInt("VENDOR NUMBER"));              
                ins.setTimestamp(5, rs.getTimestamp("EXPIRATION DATE")); 
                ins.setTimestamp(6, rs.getTimestamp("MODIFIED_DATETIME"));
                //Add to Batch (you could executeUpdate here but if you have los of rows...)
                ins.addBatch();
                if(++batchnr % MAXBATCH == 0) {
                    ins.executeBatch();
                }
            }
            //if number of rows was not aligned on MAXBATCH size...
            ins.executeBatch();                     
        }                   
    }
}