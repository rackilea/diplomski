import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HelloWorld extends JFrame {

    public HelloWorld() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Box b = Box.createVerticalBox();

        // Labels
        JLabel bold = new JLabel("I'm bold !");
        bold.setFont(bold.getFont().deriveFont(Font.BOLD));
        JLabel notBold = new JLabel("<html><em>I'm not bold !</em></html>");
        b.add(bold);
        b.add(notBold);

        // Scrollbars example
        JPanel scrollViewPort = new JPanel();
        scrollViewPort.setPreferredSize(new Dimension(400, 200));
        JScrollPane scroll = new JScrollPane(scrollViewPort);
        b.add(scroll);
        add(b, BorderLayout.CENTER);

        // Bold menu
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item = new JMenuItem("Item");
        menu.add(item);
        menubar.add(menu);
        setJMenuBar(menubar);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                HelloWorld app = new HelloWorld();
                app.setVisible(true);
            }
        });
    }
}