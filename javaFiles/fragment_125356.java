import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ProgressMonitorInputStream;
import javax.swing.SwingWorker;

public class ProgressBarDemo extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton button;

    ProgressBarDemo() {
        button = new JButton("Click me!");
        ButtonActionListener bal = new ButtonActionListener();
        button.addActionListener(bal);

        this.getContentPane().add(button);
    }

    public void go() {

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void copyFile() {

        File file = new File("...");

        BufferedInputStream bis;
        BufferedOutputStream baos;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            ProgressMonitorInputStream pmis = new ProgressMonitorInputStream(
                            this,
                            "Reading... " + file.getAbsolutePath(),
                            bis);

            pmis.getProgressMonitor().setMillisToPopup(10);
            baos = new BufferedOutputStream(new FileOutputStream("..."));

            byte[] buffer = new byte[2048];
            int nRead = 0;

            while ((nRead = pmis.read(buffer)) != -1) {
                baos.write(buffer, 0, nRead);
            }

            pmis.close();
            baos.flush();
            baos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            button.setEnabled(false);
            SwingWorker worker = new SwingWorker() {

                @Override
                protected Object doInBackground() throws Exception {
                    copyFile();
                    return null;
                }

                @Override
                protected void done() {
                    button.setEnabled(true);
                }

            };

            worker.execute();
        }

    }

    public static void main(String[] args) {
        ProgressBarDemo demo = new ProgressBarDemo();
        demo.go();
    }
}