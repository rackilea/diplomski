import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.java.dev.designgridlayout.DesignGridLayout;

public class Demo {

    private void createAndShowGUI() {

        JLabel i5l1 = new JLabel("FREIGHT DETAILS");
        JLabel i5l2 = new JLabel("Date : ");
        JLabel i5l3 = new JLabel("Vehicle No. : ");
        JLabel i5l4 = new JLabel("From : ");
        JLabel i5l5 = new JLabel("Item : ");
        JLabel i5l6 = new JLabel("Quantity : ");
        JLabel i5l7 = new JLabel("Kg.");
        JLabel i5l8 = new JLabel("Rate :                                          Rs.");
        JLabel i5l15 = new JLabel("SALE DETAILS");
        JLabel i5l16 = new JLabel("Cash Sales :                             Rs. ");
        JLabel i5l17 = new JLabel("Credit :                                       Rs. ");
        JLabel i5l18 = new JLabel("EXPENSES");
        JLabel i5l19 = new JLabel("Food & Tea :                            Rs. ");
        JLabel i5l20 = new JLabel("Wages :                                   Rs. ");
        JLabel i5l21 = new JLabel("Miscellaneous Expenses :     Rs. ");

        JTextField i5t1 = new JTextField(20);
        JTextField i5t2 = new JTextField(20);
        JTextField i5t3 = new JTextField(20);
        JTextField i5t4 = new JTextField(20);
        JTextField i5t11 = new JTextField(20);
        JTextField i5t12 = new JTextField(20);
        JTextField i5t13 = new JTextField(20);
        JTextField i5t14 = new JTextField(20);

        JComboBox i5cb1 = new JComboBox<>();
        JComboBox i5cb2 = new JComboBox<>();
        JComboBox i5cb3 = new JComboBox<>();

        JButton i5b1 = new JButton("Save");
        JButton i5b2 = new JButton("Reset"); 
        JButton i5b3 = new JButton("Close");

        JSeparator i5sep1 = new JSeparator();
        JSeparator i5sep2 = new JSeparator();
        JSeparator i5sep3 = new JSeparator();
        JSeparator i5sep4 = new JSeparator();
        JSeparator i5sep5 = new JSeparator();
        JSeparator i5sep6 = new JSeparator();

        Object[] columnNames = new Object[]{"Column # 1", "Column # 2", "Column # 3", "Column # 4"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 10);
        JTable table = new JTable(model);

        JScrollPane i5t1sp1 = new JScrollPane(table);

        JPanel freightPanel = new JPanel();
        DesignGridLayout layout1 = new DesignGridLayout(freightPanel);

        layout1.row().left().add(i5sep1).fill().withOwnRowWidth();
        layout1.row().center().add(i5l1);
        layout1.row().left().add(i5sep2).fill().withOwnRowWidth();
        layout1.row().grid(i5l2).add(i5t1);
        layout1.row().grid(i5l3).add(i5t2);
        layout1.row().grid(i5l4).add(i5cb1);
        layout1.row().grid(i5l5).add(i5cb2);
        layout1.row().grid(i5l6).add(i5t3).add(i5l7);
        layout1.row().grid(i5l8).add(i5t4);

        layout1.row().left().add(i5sep5).fill().withOwnRowWidth();
        layout1.row().center().add(i5l18);
        layout1.row().left().add(i5sep6).fill().withOwnRowWidth();
        layout1.row().grid(i5l19).add(i5t12);
        layout1.row().grid(i5l20).add(i5t13);
        layout1.row().grid(i5l21).add(i5t14);

        JPanel salePanel = new JPanel();
        DesignGridLayout layout2 = new DesignGridLayout(salePanel);

        layout2.row().left().add(i5sep3).fill().withOwnRowWidth();
        layout2.row().center().add(i5l15);
        layout2.row().left().add(i5sep4).fill().withOwnRowWidth();
        layout2.row().grid(i5l16).add(i5t11);
        layout2.row().grid(i5l17).add(i5cb3);
        layout2.row().grid().add(i5t1sp1);

        JInternalFrame internalFrame = new JInternalFrame("Daily Analysis",true,true, true, true);        

        DesignGridLayout mainLayout = new DesignGridLayout(internalFrame.getContentPane());
        mainLayout.row().grid().add(freightPanel).add(salePanel);
        mainLayout.row().left().add(new JSeparator()).fill().withOwnRowWidth();
        mainLayout.row().center().add(i5b1).add(i5b2).add(i5b3);

        internalFrame.pack();
        internalFrame.setVisible(true);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(internalFrame);
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