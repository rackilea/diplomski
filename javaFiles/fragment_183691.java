public class CustomerFrame extends javax.swing.JFrame {
    privarte Mall theMall;
    private JList storesList = new JList();

    public CustomerFrame(Customer customer, Mall theMall){
        MallCustomer mallObserver = new MallCustomer(this);
        theMall.addObserver(mallObserver);
    }

    public setStoresListModel(ListModel listModel) {
        storesList.setModel(listModel);
    }
}