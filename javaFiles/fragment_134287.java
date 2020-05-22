import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LoadingImage {

    private JPanel contentPane;
    private JTextArea logArea;
    private JLabel imageLabel;
    private ImageIcon[] images;
    private JButton startStopButton;
    private String[] path;
    private int counter;

    private Timer timer;

    private ActionListener timerAction = 
                            new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            counter %= path.length;
            imageLabel.setIcon(images[counter++]);
        }
    };

    private ActionListener buttonAction = 
                            new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (timer.isRunning()) {
                startStopButton.setText("Start");
                timer.stop();
            }
            else {
                startStopButton.setText("Stop");
                timer.start();
            }
        }
    };

    public LoadingImage() {
        imageLabel = new JLabel("Nothing to display yet...", JLabel.CENTER);
        images = new ImageIcon[5];
        path = new String[] {
            "http://i.imgur.com/922oehL.gif",
            "http://i.imgur.com/2Fim5t4.gif",
            "http://i.imgur.com/jJKlCiI.gif",
            "http://i.imgur.com/0KuZuGl.gif",
            "http://i.imgur.com/evuKoI5.gif"
        };
        counter = 0;
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Loading Image Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel(new BorderLayout(5, 5));
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        logArea = new JTextArea(10, 10);
        JScrollPane logScroller = new JScrollPane();
        logScroller.setViewportView(logArea);

        centerPanel.add(logScroller);
        centerPanel.add(imageLabel);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        startStopButton = new JButton("Stop");
        startStopButton.addActionListener(buttonAction);
        contentPane.add(startStopButton, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        new BackgroundTask().execute();
        timer = new Timer(1000, timerAction);
        timer.start();
    }

    private class BackgroundTask extends SwingWorker<ImageIcon[], String> {
        @Override
        protected ImageIcon[] doInBackground() {
            ImageIcon[] images = new ImageIcon[path.length];
            for (int i = 0; i < path.length; i++)
            {
                try {
                images[i] = new ImageIcon(ImageIO.read(new URL(path[i])));
                }catch(Exception e) {e.printStackTrace();}
                publish(String.format("Loaded : %s%n", path[i]));
            }

            return images;
        }

        @Override
        protected void process(java.util.List<String> messages) {
            for (String message : messages)
                logArea.append(message);
        }

        @Override
        protected void done() {
            try {
                images = get();             
            } catch(Exception e) {e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new LoadingImage().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}