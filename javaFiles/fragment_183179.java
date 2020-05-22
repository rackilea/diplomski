import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

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

                TransactionUI ui = new TransactionUI();
                JFrame frame = ui.getFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TransactionUI {

        private JFrame frame;
        private JScrollPane transactionPane;
        private JTable tblTransactions;

        public TransactionUI() {
            frame = new JFrame();
            frame.setTitle("Account Transactions");
            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(new BorderLayout());

            transactionPane = new JScrollPane();
            frame.getContentPane().add(transactionPane);
            String[] cols = {"Type", "Amount", "Date"};
            String sql = "SELECT type, amount, transactionDate FROM srp63_bank1017.transaction;";

            System.out.println("use getDataTable()");
            DefaultTableModel transactionList = new DefaultTableModel(100, 100);
            System.out.println("getDataTable() used");
            tblTransactions = new JTable(transactionList);
            tblTransactions.setFillsViewportHeight(true);
            tblTransactions.setShowGrid(true);
            tblTransactions.setGridColor(Color.BLACK);
            transactionPane.setViewportView(tblTransactions);

            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton btnClose = new JButton("Close");
            buttons.add(btnClose);
            frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        }

        public JFrame getFrame() {
            return frame;
        }
    }

}