import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Demo {

    private void createAndShowGUI() {

        JLabel label = new JLabel("Title");
        label.setFont(label.getFont().deriveFont(Font.BOLD | Font.ITALIC, 18));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(label);

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Column # 1", "Column # 2"}, 0);
        model.addRow(new Object[]{"Property # 1", "Value # 1"});
        model.addRow(new Object[]{"Property # 2", "Value # 2"});
        model.addRow(new Object[]{"Property # 3", "Value # 3"});

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);            

        JButton button = new JButton("Log In");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(button);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.add(topPanel, BorderLayout.NORTH);
        content.add(scrollPane, BorderLayout.CENTER);
        content.add(bottomPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {                
                new Demo().createAndShowGUI();
            }
        });
    }    
}