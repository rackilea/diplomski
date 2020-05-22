public abstract class JPanelTicket extends JPanel {

    JCatalog jcat;

    public JPanelTicket() {
        jcat = new JCatalog();
        initComponents();
    }

    public void init(){
        jcat = jcat.getComponent(); //Here's the problem
    }
}