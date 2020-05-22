import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class LayoutTest {

    private JMenuBar menuBar;
    private JMenu fileMenu, windowMenu, helpMenu;
    private JMenuItem fileNew, fileOpen, fileSave, windowTheme, windowLayout, windowProperties, helpWelcome, helpHelp, helpAbout;
    private JTextArea mainTextArea;

    public LayoutTest() {
        JPanel mainCard = new JPanel(new BorderLayout(8, 8));
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        windowMenu = new JMenu("Window");
        helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        menuBar.add(helpMenu);

        final CardLayout layout = new CardLayout(); 
        final JPanel cards = new JPanel(layout);
        cards.add(mainCard, "2");

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("One", createPane());
        tabbedPane.add("Two", createPane());
        tabbedPane.add("Three", createPane());
        tabbedPane.add("Four", createPane());

        mainTextArea = new JTextArea(20, 40);

        mainCard.add(tabbedPane, BorderLayout.WEST);
        mainCard.add(new JScrollPane(mainTextArea));

        JFrame window = new JFrame("Pseudo code text editor");
        window.setJMenuBar(menuBar);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(cards);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    protected JPanel createPane() {

        return new JPanel() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }

        };

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LayoutTest();
            }
        });
    }
}