import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Cook implements ActionListener{

    private enum Actions {
        Start, Stop, Setting, Exit
      }

    JLabel minsleft;
    int start = 0, counter, stop = 0, close = 0, whileloop = 0;

     JFrame frame = new JFrame("SMART STOVE");
    public void Cook() {

//        Cook instance = new Cook();
        // TODO Auto-generated method stub
         JLabel minsleft = new JLabel();
         minsleft.setFont(new Font("Serif", Font.BOLD, 17));
         minsleft.setBounds(100,300,250,40);

         try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\cook.png")))));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   

            JButton Start = new JButton("Start");
            Start.setFont(new Font("monospaced", Font.BOLD, 30));
            Start.setActionCommand(Actions.Start.name());
            Start.addActionListener(this);          
            Start.setBounds(150, 180, 200, 100);
            frame.add(Start);

            JButton Stop = new JButton("Stop");
            Stop.setFont(new Font("monospaced", Font.BOLD, 30));
            Stop.setActionCommand(Actions.Stop.name());
            Stop.addActionListener(this);           
            Stop.setBounds(360, 180, 200, 100);

            frame.add(Stop);
            countdownLabel.setBounds(360, 250, 200, 100);
            frame.add(countdownLabel);

            frame.setLayout(null);
            frame.setSize(700, 500);
            frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        if (evt.getActionCommand() == Actions.Start.name()) {
            start = 1;
            t.start();
          }

        if (evt.getActionCommand() == Actions.Stop.name()) {
            close = 1;
          }
        System.out.println("Done");
    }

    final JLabel countdownLabel = new JLabel("Waiting. . . ");    
    public Timer t = new Timer(1000, new ActionListener() {
        int time = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            time++;
            countdownLabel.setText(format(time / 60) + ":" + format(time % 60));
            System.out.println(format(time / 60) + ":" + format(time % 60));
            if (close == 1) {
                final Timer timer = (Timer) e.getSource();
                timer.stop();
                System.out.println("Stopped");
            }
        }
    });

    private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        new Cook().Cook();
    }

}