import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class App {
    JFrame frame = new JFrame();
    DefaultTableModel model = new DefaultTableModel(new Object[][] {},
            new String[] { "Country", "City", "Street" });
    JTable table = new JTable(model);
    JButton button = new JButton("Remove");
    JTextField countryTxt = new JTextField();

    public App() {
        data();
        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            // get the current selected row
                            int i = table.getSelectedRow();
                            // if there is a selected row, update the text field
                            if(i >= 0) {
                               countryTxt.setText((String) model
                                    .getValueAt(i, 0));
                            }
                        }
                    }
                });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // get the current selected row
                int i = table.getSelectedRow();
                // if there's no selection, but there are some rows,
                // we'll just delete the first row
                if(i < 0 && model.getRowCount() > 0) {
                   i = 0;
                }

                // if we have a valid row to delete, do the deletion
                if(i >= 0) {
                    countryTxt.setText("");
                    model.removeRow(i);
                    table.revalidate();
                }
            }
        });
        frame.add(countryTxt,BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void data() {
        model.addRow(new String[] { "USA", "New York", "First street" });
        model.addRow(new String[] { "Russia", "Moscow", "Second street" });
        model.addRow(new String[] { "Japan", "Osaka", "Osaka street" });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}