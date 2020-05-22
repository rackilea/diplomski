import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class MyGui2 extends JPanel {
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private SwappingComponent swappingComponent = new SwappingComponent(progressBar);

    public MyGui2() {
        progressBar.setStringPainted(true);
        int delay = 100;
        new Timer(delay, new ActionListener() {
            private int value = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setValue(value);

                if (value >= 100) {
                    value = 0;
                } else {
                    value += 2;
                    value = Math.min(value, 100);
                }
            }
        }).start();
        JPanel northPanel = new JPanel(new GridLayout(1, 0, 5, 5));
        northPanel.add(new JButton(new ShowAction("Show")));
        northPanel.add(new JButton(new HideAction("Hide")));

        JPanel southPanel = new JPanel();
        southPanel.add(new JButton("Some Component"));

        Border outsideBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border insideBorder = BorderFactory.createEtchedBorder();
        Border border = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
        setBorder(border);
        setLayout(new BorderLayout(6, 6));
        add(swappingComponent, BorderLayout.CENTER);
        add(northPanel, BorderLayout.PAGE_START);
        add(southPanel, BorderLayout.PAGE_END);
    }

    private class ShowAction extends AbstractAction {
        public ShowAction(String name) {
            super(name);
            putValue(MNEMONIC_KEY, (int) name.charAt(0));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            swappingComponent.showComponent(true);
        }
    }

    private class HideAction extends AbstractAction {
        public HideAction(String name) {
            super(name);
            putValue(MNEMONIC_KEY, (int) name.charAt(0));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            swappingComponent.showComponent(false);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("MyGui2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyGui2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

}