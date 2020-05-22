package mysqlfix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class JDBC {

    static Connection con = null;
    static boolean b;
    static PreparedStatement state;

    public static void setCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lottery", "root", "123");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getCon() throws Exception {
        if (con == null) {
            setCon();
        }
        return con;
    }

    public static boolean putData(String sql) {
        try {
            getCon().setAutoCommit(false);
            state = getCon().prepareStatement(sql);
            state.executeUpdate();
            getCon().commit();
            b = true;
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        }
        return b;
    }

// connection commit
    public static void commit() {
        try {
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // rollback data
    public static void rollback() {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

// close statement
    public static void putClose() {
        try {
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // close connection

    public static void conClose() {
        try {
            con.setAutoCommit(true);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// clear prepared statement
    public static void putClear() {
        try {
            if (state != null && !state.isClosed()) {
                state.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// clear the connection
    public static void conClear() {
        try {
            if (con != null && !con.isClosed()) {
                con.setAutoCommit(true);
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet getData(String sql) throws Exception {
        Statement state = getCon().createStatement();
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }

    public void saveTotal(JTextField txtGtotal, JTextField txtPTotal) {
        SuperDAO superDAO = new SuperDAO();

        if (superDAO.getMaxIdFromOrder() > 0) {
            Date date1;
            date1 = new Date();
            String txtGTotalFromTextField = txtGtotal.getText();
            String txtPTotalFromTextField = txtPTotal.getText();
            boolean b1 = false;
                    //regarding the transaction id...
            //this changes whilst updating the table transaction.

            int transactionId = -1;
            if (txtGTotalFromTextField.matches("[a-zA-Z]")) {
                transactionId = superDAO.insertOrderIntoTransaction(date1, txtGTotalFromTextField);
                //b1 = JDBC.putData("insert into transaction(tr_date, amount, tr_type) values ('" + date1 + "' , '" + txtGTotalFromTextField + "' , 'order')");
            }
            if (transactionId > 0) {
                try {
                } catch (Exception ex) {
                    Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (txtPTotalFromTextField.matches("[a-zA-Z]")) {
                    transactionId = superDAO.insertProfitIntoTransaction(date1, txtGTotalFromTextField);
                }
                JDBC.putData("insert into o_de(or_id, tr_id, oday, gtotal) values ('" + superDAO.getMaxIdFromOrder() + "' , '" + transactionId + "','" + date1 + "','" + txtGtotal.getText() + "' )");
                JDBC.putData("insert into order_profit(or_id, tr_id, ptotal) values ('" + superDAO.getMaxIdFromOrder() + "' , '" + transactionId + "','" + txtPTotal.getText() + "' )");

                                                        //JDBC.commit();
                //JOptionPane.showMessageDialog(null, "Order Saved Sucessfully..");
                JDBC.putClose();
                JDBC.conClose();

            }

        }

    }

}



package mysqlfix;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edm
 */
public class SuperDAO {

    Connection conn;

    public SuperDAO() {
        try {
            this.conn = JDBC.getCon();
        } catch (Exception ex) {
            Logger.getLogger(SuperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMaxIdFromOrder() {

        try {
            ResultSet rs = JDBC.getData("select MAX(or_id) as or_id from `order`");
            if (rs.first()) {

                return rs.getInt("or_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuperDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SuperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int getMaxIdFromTransaction() {
        ResultSet rs;
        try {
            rs = JDBC.getData("select MAX(tr_id) as tr_id from transaction");
            if (rs.first()) {
            return rs.getInt("tr_id");
        }
        } catch (Exception ex) {
            Logger.getLogger(SuperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }


    public int insertOrderIntoTransaction(Date date, String text) {
        JDBC.putData("insert into transaction(tr_date, amount, tr_type) values ('" + date + "' , '" + text + "' , 'order')");
        return getMaxIdFromTransaction();
    }

     public int insertProfitIntoTransaction(Date date, String text) {
        JDBC.putData("insert into transaction(tr_date, amount, tr_type) values ('" + date + "' , '" + text + "' , 'profit')"); 

        return getMaxIdFromTransaction();
    }



}