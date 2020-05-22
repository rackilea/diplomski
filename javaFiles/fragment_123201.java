import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.addTab("One", new TabPane(tabbedPane));
                tabbedPane.addTab("Two", new TabPane(tabbedPane));
                tabbedPane.addTab("Three", new TabPane(tabbedPane));
                tabbedPane.addTab("Four", new TabPane(tabbedPane));

                tabbedPane.addContainerListener(new ContainerListener() {
                    @Override
                    public void componentAdded(ContainerEvent e) {
                    }

                    @Override
                    public void componentRemoved(ContainerEvent e) {
                        System.out.println("Removed " + e.getChild());

                    }
                });

                tabbedPane.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        System.out.println(tabbedPane.getSelectedIndex());
                    }
                });

                JFrame frame = new JFrame();
                frame.add(tabbedPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TabPane extends JPanel {
        private JTabbedPane parent;

        public TabPane(JTabbedPane parent) {
            this.parent = parent;
            setLayout(new GridBagLayout());
            JButton btn = new JButton("Close");
            add(btn);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parent.remove(TabPane.this);
                }
            });
        }

    }

}