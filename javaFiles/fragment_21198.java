import java.awt.Toolkit;

public class Home extends javax.swing.JFrame implements Runnable {

    public Home() {
        initComponents();
        setIcon();
    }

    private void initComponents(){}
    @Override public void run() {}

    public static void main(String args[]) {
        Home home = new Home();     
    }

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon.png")));
    }

}