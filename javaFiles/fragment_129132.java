import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainTest {

JLabel countLabel = new JLabel("");
Thread printer = null;

public static void main(String[] args) {
    // passes in a directory

    MainTest test = new MainTest();
}

public MainTest() {
    JFrame frame = new JFrame("TestFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    frame.setBounds(new Rectangle(200, 200, 200, 200));
    JButton button = new JButton("Open Instances");
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    OpenStuff();
                }

            });
            t.start();
        }

    });
    countLabel.setSize(new Dimension(50, 50));

    panel.add(countLabel);
    panel.add(Box.createVerticalStrut(20));
    panel.add(button);
    printer = new Thread(new CountPrinter());
    printer.start();
    frame.add(panel);
    frame.show();
}

private void OpenStuff() {
    int count = 0;
    ArrayList<Thread> threads = new ArrayList<Thread>();
    while (count < 5) {
        Thread t = new Thread(new OpenNotePadAndJoin());
        t.start();
        threads.add(t);
        count++;
    }

    for (Thread t : threads) {
        try {
            t.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    printer.interrupt();
}

private static class SharedResource {
    public static volatile int count = 0;
}

private class CountPrinter implements Runnable {

    @Override
    public void run() {
        while (true) {
            countLabel.setText(String.valueOf(SharedResource.count));
            countLabel.getParent().repaint();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                break;
            }
        }
    }

}

private class OpenNotePadAndJoin implements Runnable {

    @Override
    public void run() {
        ProcessBuilder pb = new ProcessBuilder("notepad");
        try {

            Process p = pb.start();
            SharedResource.count++;
            p.waitFor();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            SharedResource.count--;
        }

    }

}
}