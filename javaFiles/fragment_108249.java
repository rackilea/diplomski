package testOpdracht1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.InputStream;

public class MainMenu extends JFrame implements KeyListener {
    final JLabel label1 = new JLabel("text1");
    public MainMenu() {
        initUI();
    }

    public final void initUI() {
        add(label1);

        addKeyListener(this);

        setTitle("Bla");
        setPreferredSize(new Dimension(400,250));
        setMinimumSize(getPreferredSize());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void keyPressed(KeyEvent e) {
          label1.setText("foo");
    }

    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainMenu ex = new MainMenu();
                ex.setVisible(true);
            }
        });
    }    
}