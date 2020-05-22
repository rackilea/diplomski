import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HangMan {

    public static void main(String[] args) {
        new HangMan();
    }

    public HangMan() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<JLabel> listSecrets;
        private String secretWord = "rabbit";
        private Set<Character> guesses;
        private JTextField guessField;

        private JLabel numberOfGuessesLabel;
        private int numberOfGuesses = 0;

        public TestPane() {
            guesses = new HashSet<>(25);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            guessField = new JTextField(2);
            JButton applyGuess = new JButton("Apply");

            JPanel guessPane = new JPanel();
            guessPane.add(new JLabel("Make a guesss:"));
            guessPane.add(guessField);
            guessPane.add(applyGuess);

            add(guessPane, gbc);

            listSecrets = new ArrayList<>(25);

            JPanel guessesPanel = new JPanel();
            for (char c : secretWord.toCharArray()) {
                JLabel label = new JLabel("_");
                listSecrets.add(label);
                guessesPanel.add(label);
            }

            add(guessesPanel, gbc);

            numberOfGuessesLabel = new JLabel("0");
            add(numberOfGuessesLabel, gbc);

            GuessHandler handler = new GuessHandler();
            guessField.addActionListener(handler);
            applyGuess.addActionListener(handler);
        }

        public class GuessHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = guessField.getText();
                // This section should be part of your model layer, but for brevity
                // I've implemented directly....
                if (text.trim().length() > 0) {
                    if (!guesses.contains(text.charAt(0))) {
                        guesses.add(text.charAt(0));

                        int index = -1;
                        int searchFrom = 0;
                        while ((index = secretWord.indexOf(text, searchFrom)) != -1) {
                            JLabel label = listSecrets.get(index);
                            label.setText(Character.toString(text.charAt(0)).toUpperCase());
                            searchFrom = index + 1;
                        }

                        numberOfGuesses++;
                        numberOfGuessesLabel.setText(String.valueOf(numberOfGuesses));
                    }
                }
                guessField.setText(null);
                guessField.requestFocusInWindow();
            }

        }

    }

}