import java.awt.BorderLayout;
import javax.swing.*;

public class Main extends JFrame {

    View view = new View();

    public Main() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(view);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}

class View extends JPanel {

    public View() {
        super(new BorderLayout()); // Just 1 line difference!
        JTabbedPane tpane = new JTabbedPane();
        JPanel panel = new JPanel();
        panel.add(new JButton("Button 1"));
        tpane.addTab("Tab1", panel);

        JPanel panel2 = new JPanel();
        panel2.add(new JButton("Button 2"));
        tpane.addTab("Tab2", panel2);

        this.add(tpane);
    }
}