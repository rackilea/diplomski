import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class NewClass1 {
    private String arg = "";
    private SwingWorker<Void, Integer> worker;

    public NewClass1() {
        JFrame frame = new JFrame("Datacolor software automate");
        JButton stop = new JButton("STOP");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                worker.cancel(true);
            }
        });

        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                initializeWorker();
                worker.execute();
            }
        });

        frame.add(button);
        frame.add(stop);
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initializeWorker() {
        worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                int i = 0;
                while (!isCancelled()) {
                    i++;
                    publish(i); // give this i to "process" method
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                int i = chunks.get(0);
                System.out.println(i);
            }
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewClass1());
    }

}