import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(2);
        TCPServer tcpServer = new TCPServer(15002, true);
        FutureTask<Integer> ft = new FutureTask<>(tcpServer);
        pool.execute(ft);

        final JFrame frame = new JFrame("TCP Server");
        final JLabel print = new JLabel("Program is executing!");
        final JToggleButton switchButton = new JToggleButton("Cancel");
        final JLabel status = new JLabel("Waiting for connection");
        switchButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    status.setText("Cancelled");
                    pool.shutdown();
                }
            }
        });

        frame.getContentPane().add(print, BorderLayout.NORTH);
        frame.getContentPane().add(switchButton, BorderLayout.CENTER);
        frame.getContentPane().add(status, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        int i = 0;
        while (!switchButton.isSelected() && !ft.isDone()) {
            i++;
            String temp = "Waiting for connection... " + i + " s.";
            status.setText(temp);
            int sleep = i * 1000;
            Thread.sleep(sleep);
        }

    }
}