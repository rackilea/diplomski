import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoaderDisplay {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }


                final JFrame frame = new JFrame();
                JPanel panel = new JPanel();

                JButton button1 = new JButton("Load me up");

//        ImageIcon loading = new ImageIcon("loading_icon.gif");
                final JLabel label = new JLabel("Loading... ", JLabel.CENTER);

                label.setVisible(false);
                frame.add(panel);
                panel.add(button1);
                panel.add(label);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        // event start
                        label.setVisible(true);

                        new SwingWorker<Void, String>() {
                            @Override
                            protected Void doInBackground() throws Exception {
                                // Worken hard or hardly worken...
                                Thread.sleep(2000);
                                return null;
                            }

                            @Override
                            protected void done() {
                                label.setVisible(false);
                            }
                        }.execute();

                    }
                });

            }
        });
    }
}