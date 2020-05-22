import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class TestSwingWorker {

    private JTextField progressTextField;

    protected void initUI() {
        final JFrame frame = new JFrame();
        frame.setTitle(TestSwingWorker.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Clik me to start work");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doWork();
            }
        });
        progressTextField = new JTextField(25);
        progressTextField.setEditable(false);
        frame.add(progressTextField, BorderLayout.NORTH);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    protected void doWork() {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 100; i++) {
                    // Simulates work
                    Thread.sleep(10);
                    publish(i);
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                progressTextField.setText(chunks.get(chunks.size() - 1).toString());
            }

            @Override
            protected void done() {
                progressTextField.setText("Done");
            }
        };
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestSwingWorker().initUI();
            }
        });
    }
}