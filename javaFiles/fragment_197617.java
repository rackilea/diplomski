public abstract class JPanelTicket extends JPanel {

    JCatalog jcat;

    public JPanelTicket() {
        initComponents();
    }

    public void init(){
        jcat = jcat.getComponent(); //Here's the problem
    }

    public void setJCatalog(JCatalog jcat) {
        this.jcat = jcat;
    }
}