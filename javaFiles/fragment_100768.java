import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestTabSize {

    public static void main(String[] args) {
        new TestTabSize();
    }

    public TestTabSize() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JPanel panel = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(200, 200);
                    }
                };

                panel.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        System.out.println("Resized to " + e.getComponent().getSize());
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                        System.out.println("Moved to " + e.getComponent().getLocation());
                    }
                });

                System.out.println("Before been added = " + panel.getSize());

                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.addTab("test", panel);

                System.out.println("Before been added to tab = " + panel.getSize());

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                System.out.println("Before been added to frame = " + panel.getSize());
                frame.add(tabbedPane);
                System.out.println("After been added to frame = " + panel.getSize());
                frame.pack();
                System.out.println("After been packed = " + panel.getSize());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                System.out.println("After been visible = " + panel.getSize());
            }
        });
    }

}