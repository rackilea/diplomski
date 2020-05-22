import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AdminFrame extends javax.swing.JFrame {

    private Mall theMall = new Mall(); //!!

    public AdminFrame() {
        initComponents();
        //!! theMall = new Mall();
    }

    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addStoreBtn = new javax.swing.JButton();
        newCustBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        jLabel1.setText("jLabel1");

        addStoreBtn.setText("Add Store");
        addStoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theMall.addNewStore(jTextField1.getText());
            }
        });
        addStoreBtn.setMnemonic(KeyEvent.VK_S);

        newCustBtn.setText("New Customer");
        newCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // !! CustomerFrame newCust = new CustomerFrame();
                CustomerDialog newCust = new CustomerDialog(AdminFrame.this, theMall);
                newCust.pack();
                newCust.setLocationByPlatform(true);
                newCust.setVisible(true);
            }
        });
        newCustBtn.setMnemonic(KeyEvent.VK_C);

        JPanel mainPanel = new JPanel();
        mainPanel.add(jLabel1);
        mainPanel.add(jTextField1);
        mainPanel.add(addStoreBtn);
        mainPanel.add(newCustBtn);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JButton addStoreBtn;
    private javax.swing.JButton newCustBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;

}

class MallObserver implements Observer {

    private Mall mallUpdate;
    private CustomerDialog customerDialog; // !!

    // !!
    public MallObserver(CustomerDialog customerFrame) {
        this.customerDialog = customerFrame; // !!
    }

    @Override
    public void update(Observable o, Object arg) {
        mallUpdate = (Mall) o;
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < mallUpdate.getStores().size(); i++) {
            listModel.addElement(mallUpdate.getStores().get(i));
        }

        customerDialog.setListModel(listModel);
    }

}

@SuppressWarnings("serial")
class CustomerDialog extends JDialog {  //!!

    // !!!!!!! public CustomerFrame() {
    // initComponents();
    // }

    public void setListModel(ListModel<String> listModel) {
        jList1.setModel(listModel);
    }

    public CustomerDialog(AdminFrame adminFrame, Mall theMall) {
        super(adminFrame, "Customer Dialog", ModalityType.MODELESS);
        initComponents();
        // !! MallObserver mallObs = new MallObserver();
        MallObserver mallObs = new MallObserver(this); // !!
        theMall.addObserver(mallObs);
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new JList<>();
        jList1.setPrototypeCellValue("                               ");
        jList1.setVisibleRowCount(15);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1);

        pack();
    }

    // public static javax.swing.JList jList1;
    private JList<String> jList1;
    private JScrollPane jScrollPane1;
}

class Mall extends Observable {
    private ArrayList<String> stores;

    public Mall() {
        stores = new ArrayList<String>();
    }

    public void addNewStore(String store) {
        stores.add(store);
        setChanged();
        notifyObservers(store);
    }

    public ArrayList<String> getStores() {
        return stores;
    }


}