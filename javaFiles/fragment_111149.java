import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @see https://stackoverflow.com/a/22766921/230513
 * @see https://stackoverflow.com/questions/8955638
 */
public class NewMain {

    public static void main(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty(
            "com.apple.mrj.application.apple.menu.about.name", "Name");
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                JFrame frame = new JFrame("Gabby");
                final JPanel dm = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(320, 240);
                    }
                };
                dm.setBorder(BorderFactory.createLineBorder(Color.blue, 10));

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(dm);
                frame.pack();
                frame.setLocationByPlatform(true);

                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("File");
                JMenuItem item = new JMenuItem("Item");
                fileMenu.add(item);
                item.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Here");
                    }
                });
                menuBar.add(fileMenu);
                frame.setJMenuBar(menuBar);
                frame.setVisible(true);
            }
        });
    }
}