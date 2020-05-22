import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class KaraokeTest {

    private int[] timingsArray = {1000, 1000, 9000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};//word/letters timings
    private String[] individualWordsToHighlight = {" \nHello\n", " world\n", " Hello", " world", " Hello", " world", " Hello", " world", " Hello", " world"};//each individual word/letters to highlight
    private int count = 0;
    private final JTextPane jtp = new JTextPane();
    private final JButton startButton = new JButton("Start");
    private final JFrame frame = new JFrame();
    //create Arrays of individual letters and their timings
    final ArrayList<String> chars = new ArrayList<>();
    final ArrayList<Long> charsTiming = new ArrayList<>();

    public KaraokeTest() {
        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        for (String s : individualWordsToHighlight) {
            String tmp = jtp.getText();
            jtp.setText(tmp + s);
        }
        jtp.setEditable(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                startButton.setEnabled(false);
                count = 0;
                charsTiming.clear();
                chars.clear();

                for (String s : individualWordsToHighlight) {
                    for (int i = 0; i < s.length(); i++) {
                        chars.add(String.valueOf(s.charAt(i)));
                        //System.out.println(String.valueOf(s.charAt(i)));
                    }
                }

                //calculate each letters timings
                for (int x = 0; x < timingsArray.length; x++) {
                    for (int i = 0; i < individualWordsToHighlight[x].length(); i++) {
                        individualWordsToHighlight[x] = individualWordsToHighlight[x].replace("\n", " ").replace("\r", " ");//replace line breaks
                        charsTiming.add((long) (timingsArray[x] / individualWordsToHighlight[x].trim().length()));//dont count spaces
                        //System.out.println(timingsArray[x] / individualWordsToHighlight[x].length());
                    }
                }

                Timer t = new Timer(1, new AbstractAction() {
                    long startTime = 0;
                    long acum = 0;
                    long timeItTookTotal = 0;
                    long dif = 0, timeItTook = 0, timeToTake = 0;
                    int delay = 0;

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (count < charsTiming.size()) {

                            if (count == 0) {
                                startTime = System.nanoTime();
                                System.out.println("Started: " + startTime);
                            }

                            timeToTake = charsTiming.get(count);
                            acum += timeToTake;

                            //highlight the next word
                            highlightNextWord();

                            //System.out.println("Acum " + acum);
                            timeItTook = (acum - ((System.nanoTime() - startTime) / 1000000));
                            timeItTookTotal += timeItTook;
                            //System.out.println("Elapsed since start: " + (System.nanoTime() - startTime));
                            System.out.println("Time the char should take: " + timeToTake);
                            System.out.println("Time it took: " + timeItTook);
                            dif = (timeToTake - timeItTook);
                            System.out.println("Difference: " + dif);
                            //System.out.println("Difference2 " + (timeToTake - dif));

                            //calculate start of next letter to highlight less the difference it took between time it took and time it should actually take
                            delay = (int) (timeToTake - dif);

                            if (delay < 1) {
                                delay = 1;
                            }

                            //restart timer with new timings
                            ((Timer) ae.getSource()).setInitialDelay((int) timeToTake);//timer is usually faster thus the entire highlighting will be done too fast
                            //((Timer) ae.getSource()).setInitialDelay(delay);
                            ((Timer) ae.getSource()).restart();

                        } else {//we are at the end of the array
                            long timeStopped = System.nanoTime();
                            System.out.println("Stopped: " + timeStopped);
                            System.out.println("Time it should take in total: " + acum);
                            System.out.println("Time it took using accumulator of time taken for each letter: " + timeItTookTotal
                                    + "\nDifference: " + (acum - timeItTookTotal));
                            long timeItTookUsingNanoTime = ((timeStopped - startTime) / 1000000);
                            System.out.println("Time it took using difference (endTime-startTime): " + timeItTookUsingNanoTime
                                    + "\nDifference: " + (acum - timeItTookUsingNanoTime));
                            reset();
                            ((Timer) ae.getSource()).stop();//stop the timer
                        }
                        count++;//increment counter
                    }
                });
                t.setRepeats(false);
                t.start();
            }
        });

        frame.add(jtp, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void reset() {
        startButton.setEnabled(true);
        jtp.setText("");
        for (String s : individualWordsToHighlight) {
            String tmp = jtp.getText();
            jtp.setText(tmp + s);
        }
        JOptionPane.showMessageDialog(frame, "Done");
    }

    private void highlightNextWord() {
        //we still have words to highlight
        int sp = 0;
        for (int i = 0; i < count + 1; i++) {//get count for number of letters in words (we add 1 because counter is only incrementd after this method is called)
            sp += 1;
        }

        while (chars.get(sp - 1).equals(" ")) {
            sp += 1;
            count++;
        }

        //highlight words
        Style style = jtp.addStyle("RED", null);
        StyleConstants.setForeground(style, Color.RED);
        ((StyledDocument) jtp.getDocument()).setCharacterAttributes(0, sp, style, true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KaraokeTest();
            }
        });
    }
}