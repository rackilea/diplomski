package test;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class SwingWorkerExample extends JFrame {
    /*
     * Worker has Void doInBackground a.k.a, doInBackground method needs to return nothing.
     * Worker needs to process-publish Integers.
     */
    private SwingWorker<Void, Integer> writeToFileWorker = null;
    private JLabel gifLabel;
    private JButton doSomethingHeavy;

    public SwingWorkerExample() {
        super("Just a test.");
        createWorker();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        gifLabel = new JLabel();
        ImageIcon gif = new ImageIcon("C:/Users/George/Desktop/giphy.gif");
        gifLabel.setIcon(gif);
        gifLabel.setVisible(false); //Initialy non visible
        gifLabel.setHorizontalTextPosition(JLabel.CENTER);
        gifLabel.setVerticalTextPosition(JLabel.BOTTOM);
        gifLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(gifLabel, BorderLayout.CENTER);

        doSomethingHeavy = new JButton("Do something heavy in another thread and start dancing...");
        doSomethingHeavy.addActionListener(e -> {
            //Before start the worker, show gif and disable the button
            doSomethingHeavy.setEnabled(false);
            gifLabel.setVisible(true);
            writeToFileWorker.execute();
        });
        getContentPane().add(doSomethingHeavy, BorderLayout.PAGE_END);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    private void createWorker() {
        writeToFileWorker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                File fileToWrite = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "hello_worlds.txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite));) {
                    for (int line = 0; line < 1000; line++) {
                        writer.append("Hello World! My name is Swing Worker.");
                        writer.append(System.lineSeparator());
                        Thread.sleep(10);
                        publish(line);
                    }
                }
                return null;
            }

            /*
             * Runs in Event Dispatch Thread (EDT)
             */
            @Override
            protected void process(List<Integer> chunks) {
                int line = chunks.get(0);//First parameter is the line
                gifLabel.setText("Written " + line + " lines in the txt.");
                super.process(chunks);
            }

            /*
             * Runs in Event Dispatch Thread (EDT)
             */
            @Override
            protected void done() {
                //When swing worker is finished, a.k.a the heavy work, stop the gif and enable the button
                gifLabel.setVisible(false);
                doSomethingHeavy.setEnabled(true);
                super.done();
            }
        };

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingWorkerExample swe = new SwingWorkerExample();
            swe.setVisible(true);
        });
    }
}