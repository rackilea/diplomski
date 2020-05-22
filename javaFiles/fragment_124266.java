import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Test {

    private final JComboBox itemList;

    public Test() throws SQLException {
        itemList = new JComboBox(viewTable(getConnection(), command));
        JButton button = new JButton("Populate");
        button.addActionListener(new ButtonHandler());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(itemList);
        panel.add(button);

        JOptionPane.showMessageDialog(null, panel);
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ComboBoxModel model = viewTable(getConnection(), command);
                itemList.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) throws SQLException {
        Test test = new Test();
    }

    private ComboBoxModel viewTable(Connection con, String command) throws SQLException {
        List<String> list = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(command);

            while (rs.next()) {
                list.add(rs.getString("itemName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DefaultComboBoxModel(list.toArray());

    }

    public final String userName = "root";
    private final String password = "";
    private final String serverName = "localhost";
    private final int portNumber = 3306;
    private final String dbName = "alphapos";
    private final String command = "select itemName from item";

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        conn = DriverManager.getConnection("jdbc:mysql://"
                + this.serverName + ":" + this.portNumber + "/" + this.dbName,
                connectionProps);

        return conn;
    }
}