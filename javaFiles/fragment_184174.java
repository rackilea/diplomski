import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestHangMan01 {

    public static void main(String[] args) {
        new TestHangMan01();
    }

    public TestHangMan01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new Hangman());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class HangManModel {

        public int youLose;
        public int wrongGuess;
        public String message;
        public String theWord;
        public StringBuffer guessWord;
        private Set<ChangeListener> listeners;

        public HangManModel() {
            listeners = new HashSet<>(25);
        }

        public void setTheWord(String theWord) {
            this.theWord = theWord;
            guessWord = new StringBuffer(theWord.length());
            while (guessWord.length() < theWord.length()) {
                guessWord.append("_");
            }
            youLose = theWord.length();
            wrongGuess = 0;
            message = "";
            fireStateChanged();
        }

        public void addChangeListener(ChangeListener listener) {
            listeners.add(listener);
        }

        public void removeChangeListener(ChangeListener listener) {
            listeners.remove(listener);
        }

        protected void fireStateChanged() {
            if (listeners.size() > 0) {
                ChangeEvent evt = new ChangeEvent(this);
                for (ChangeListener listener : listeners) {
                    listener.stateChanged(evt);
                }
            }
        }

        public int getWrongGuess() {
            return wrongGuess;
        }

        public String getMessage() {
            return message;
        }

        public String getGuessWord() {
            return guessWord.toString();
        }

        public void setMessage(String value) {
            if (message == null ? value != null : !message.equals(value)) {
                this.message = value;
                fireStateChanged();
            }
        }

        public void guess(char letter) {
            if (!Character.isLetter(letter)) {
                setMessage("Invalid character");
            } else {
                String temp = new String(guessWord);

                if (temp.indexOf(letter) != -1) {
                    message = "Letter has already been guessed";
                } else {
                    if (theWord.indexOf(letter) == -1) {
                        wrongGuess++;
                        if (wrongGuess == youLose) {
                            setMessage("You lose! The word was '" + theWord + "'" + "\nClick restart to try again.");
                        } else {
                            setMessage("You have " + (youLose - wrongGuess) + " guesses left.");
                        }
                    } else {
                        for (int i = 0; i < theWord.length(); i++) {
                            if (theWord.charAt(i) == letter) {
                                guessWord.setCharAt(i, letter);
                            }
                        }

                        temp = new String(guessWord);

                        if (temp.indexOf('_') == -1) {
                            setMessage("You win!");
                        } else {
                            setMessage("");
                        }
                    }
                }
            }
        }
    }

    public class HangManPane extends JPanel implements ChangeListener {

        private HangManModel model;

        public HangManModel getModel() {
            return model;
        }

        public void setModel(HangManModel value) {
            if (model != value) {
                if (model != null) {
                    model.removeChangeListener(this);
                }
                this.model = value;
                if (model != null) {
                    model.addChangeListener(this);
                }
                repaint();
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            HangManModel model = getModel();

            //(left, top, right, bottom)

            g.drawLine(90, 250, 200, 250);
            g.drawLine(125, 250, 125, 150);
            g.drawLine(125, 150, 175, 150);
            g.drawLine(175, 150, 175, 175);

            if (model.getWrongGuess() > 0) { //head
                g.drawOval(170, 175, 10, 12);
            }
            if (model.getWrongGuess() > 1) { //body
                g.drawLine(175, 187, 175, 205);
            }
            if (model.getWrongGuess() > 2) { //left arm
                g.drawLine(163, 185, 173, 190);
            }
            if (model.getWrongGuess() > 3) { //right arm
                g.drawLine(177, 190, 187, 185);
            }
            if (model.getWrongGuess() > 4) { //left leg
                g.drawLine(168, 220, 173, 205);
            }
            if (model.getWrongGuess() > 5) { //right leg
                g.drawLine(177, 205, 182, 220);
            }

            g.drawString(model.getMessage(), 40, 290);
            g.drawString(model.getGuessWord(), 40, 275);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            repaint();
        }
    }

    public class Hangman extends JPanel implements ActionListener {

        public JButton restartButton;
        public JButton playButton;
        public JTextField userInput;
        private HangManModel model;

        public Hangman() {

            setModel(new HangManModel());

            setLayout(new BorderLayout());

            userInput = new JTextField();
            restartButton = new JButton("Restart");
            playButton = new JButton("Play");

            JPanel controls = new JPanel(new GridLayout(1, 4));

            controls.add(restartButton);
            controls.add(playButton);
            controls.add(new JLabel("Enter guess: "));
            controls.add(userInput);

            add(controls, BorderLayout.NORTH);

            userInput.addActionListener(this);
            restartButton.addActionListener(this);
            playButton.addActionListener(this);

            HangManPane hangManPane = new HangManPane();
            hangManPane.setModel(getModel());
            add(hangManPane);

            startGame();
        }

        public void setModel(HangManModel model) {
            this.model = model;
        }

        public HangManModel getModel() {
            return model;
        }

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == restartButton) {
                restart();
                startGame();
            }
            if (event.getSource() == playButton || event.getSource() == userInput) {
                analyzeGuess();
                userInput.setText("");
                repaint();
            } 

            setVisible(true);

        }

        public void restart() {
            startGame();
        }

        public void startGame() {
            String[] wordArray = {"computer", "science", "java", "application", "programming", "university",
                "homework", "assignment", "cactus", "flower", "button", "keyboard", "graphic", "interface",
                "collegiate", "graduate", "headphones", "building", "radiator", "flora", "fauna", "suitcase",
                "sweater", "television", "library", "elevator", "precidence", "ancient", "basketball", "bracket",
                "alphabetical", "christmas", "hannukah"};

            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(wordArray.length);
            String theWord = new String(wordArray[randomInt]);
            getModel().setTheWord(theWord);
            userInput.setText("");
        }

        private void analyzeGuess() {
            String userGuess = userInput.getText();
            if (userGuess.trim().length() > 0) {
                getModel().guess(userGuess.charAt(0));
            }
        }
    }
}