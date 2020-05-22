import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 500, 500);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new MigLayout("insets 4 4 4 4",
                "[fill,30%][fill,40%][fill,30%]", "[fill,grow]"));

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem item = new JMenuItem("Open");
        menu.add(item);
        menubar.add(menu);
        frame.setJMenuBar(menubar);

        contentPanel.add(new JScrollPane());
        contentPanel.add(new JScrollPane(new JEditorPane("text/plain", "Hello World")));
        contentPanel.add(new JScrollPane());
        frame.setContentPane(contentPanel);
        frame.setVisible(true);
    }
}