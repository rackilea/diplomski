package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @see http://stackoverflow.com/a/5696404/230513
 */
public class Launcher extends JPanel implements Runnable {

    private final JLabel label = new JLabel();
    private final JButton launch = new JButton();
    ProcessBuilder pb = new ProcessBuilder(
        "java", "-cp", "build/classes", "gui.Launcher$DialogTest");
    private volatile Process proc;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Launcher()::createGUI);
    }

    private void createGUI() {
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new Launcher());
        frame.add(new Launcher());
        frame.add(new Launcher());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Launcher() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        launch.setAlignmentX(0.5f);
        label.setAlignmentX(0.5f);
        launch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (proc == null) {
                    launch.setText("Terminate");
                    label.setText("Status: run");
                    new Thread(Launcher.this).start();
                } else {
                    proc.destroy();
                    reset();
                }
            }
        });
        this.add(launch);
        this.add(label);
        reset();
    }

    @Override
    public void run() {
        try {
            proc = pb.start();
            proc.waitFor();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace(System.err);
        }
        EventQueue.invokeLater(this::reset);
    }

    private void reset() {
        proc = null;
        launch.setText("Launch");
        label.setText("Status: idle");
    }

    private static class DialogTest {

        public static void main(String[] args) {
            EventQueue.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, "Running",
                    "Test", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            });
        }
    }
}