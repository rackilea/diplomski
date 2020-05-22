import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class SwingThread2 {
    protected static final int MAX_VALUE = 5; // our constant
    private JFrame frame;
    private JProgressBar progressBar = new JProgressBar();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingThread2 window = new SwingThread2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SwingThread2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        // frame.setBounds(100, 100, 450, 300); // avoid this
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JTextArea textArea = new JTextArea(15, 40);
        scrollPane.setViewportView(textArea);

        JButton btnNewButton = new JButton("New button");
        scrollPane.setColumnHeaderView(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // delay between timer ticks: 1000
                int timerDelay = 1000;
                new Timer(timerDelay, new ActionListener() {
                    private int counter = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // timer's stopping condition
                        if (counter >= MAX_VALUE) { // MAX_VALUE is a constant
                                                    // int = 5
                            ((Timer) e.getSource()).stop();
                        } else {
                            textArea.append("Value " + counter + "\n");
                        }
                        counter++; // increment timer's counter variable
                    }
                }).start();
            }
        });

        progressBar.setStringPainted(true);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(new JButton(new MyAction("Press Me")));
        bottomPanel.add(progressBar);

        frame.getContentPane().add(bottomPanel, BorderLayout.PAGE_END);

        // better to avoid setting sizes but instead to
        // let the components size themselves vis pack
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private class MyAction extends AbstractAction {
        public MyAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        public void actionPerformed(ActionEvent e) {
            progressBar.setValue(0);
            setEnabled(false);
            MyWorker myWorker = new MyWorker();
            myWorker.addPropertyChangeListener(new WorkerListener(this));
            myWorker.execute();
        }
    }

    private class WorkerListener implements PropertyChangeListener {
        private Action action;

        public WorkerListener(Action myAction) {
            this.action = myAction;
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                int progress = (int) evt.getNewValue();
                progressBar.setValue(progress);
            } else if ("state".equals(evt.getPropertyName())) {
                if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                    action.setEnabled(true);

                    @SuppressWarnings("rawtypes")
                    SwingWorker worker = (SwingWorker) evt.getSource();
                    try {
                        // always want to call get to trap and act on 
                        // any exceptions that the worker might cause
                        // do this even though get returns nothing
                        worker.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private class MyWorker extends SwingWorker<Void, Void> {
        private static final int MULTIPLIER = 80;
        private int counter = 0;
        private Random random = new Random();

        @Override
        protected Void doInBackground() throws Exception {
            while (counter < 100) {
                int increment = random.nextInt(10);
                Thread.sleep(increment * MULTIPLIER);
                counter += increment;
                counter = Math.min(counter, 100);
                setProgress(counter);
            }
            return null;
        }
    }
}