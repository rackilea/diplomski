import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextField field;
        private JTable table;

        public TestPane() {
            setLayout(new BorderLayout());
            field = new JTextField(20);
            table = new JTable();

            add(field, BorderLayout.NORTH);
            add(new JScrollPane(table));

            JButton update = new JButton("Update");
            add(update, BorderLayout.SOUTH);

            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        TableModel model = executeQueryWith(field.getText());
                        table.setModel(model);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(TestPane.this, "Failed to execute query", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            });
        }

        protected TableModel executeQueryWith(String value) throws SQLException {
            String url = "jdbc:mysql://localhost:3306/cinema";
            String userid = "root";
            String password = "root";
            String sql = "SELECT movie_title, timetable_starttime, timetable_movietype "
                    + "FROM Movies INNER JOIN TimeTable on timetable_movie_ID = ?";

            DefaultTableModel model = new DefaultTableModel();
            try (Connection connection = DriverManager.getConnection(url, userid, password)) {
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    stmt.setString(1, value);
                    try (ResultSet rs = stmt.executeQuery()) {
                        ResultSetMetaData md = rs.getMetaData();
                        int columns = md.getColumnCount();

                        //  Get column names
                        for (int i = 1; i <= columns; i++) {
                            model.addColumn(md.getColumnName(i));
                        }

                        //  Get row data
                        while (rs.next()) {
                            Vector<Object> row = new Vector(columns);
                            for (int i = 1; i <= columns; i++) {
                                row.add(rs.getObject(i));
                            }
                            model.addRow(row);
                        }
                    }
                }
            }
            return model;
        }

    }

}