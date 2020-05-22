import java.util.Random;
import javax.swing.JOptionPane;

public class Quiz {

    /**
     * This holds all the java questions.
     */
    private static final Question[] JAVA_QUESTIONS = new Question[]{
        new Question("Who developed Java?", 2, "Google", "Sun Microsystems", "Microsoft", "Oracle"),
        //This creates the question: Who developed java with 4 answers (google, Sun, Microsoft and Oracle)
        //The correct answer is 2 (Sun).
        new Question("What modifier is used to make a variable constant?", 3, "public", "abstract", "final", "import")
    };

    /**
     * This holds all the c++ questions.
     */
    private static final Question[] CPP_QUESTIONS = new Question[]{
        new Question("C++ is?", 4, "Interpreted", "A scripting language", "The first programming language", "Compiled")
    };

    /**
     * The users score
     */
    private int score;

    /**
     * The users name
     */
    private String name;

    /**
     * What language the user selected.
     */
    private Language lang;

    private Quiz() {
        setLookAndFeel();//Makes everything look nice
        showOpeningDialogs();//Shows the welcome dialogs
        askQuestions(10);//Asks random questions 10 times depending on what language is selected. 
    }

    /**
     * Asks random questions depending on the language chosen.
     *
     * @param maxScore the number of questions to ask
     */
    private void askQuestions(int maxScore) {
        for (int i = 0; i < maxScore; i++) {
            Question q = getRandomQuestion(lang);//Gets a random question for the language chosen.
            if (ask(q)) {//Checks if they got it correct
                JOptionPane.showMessageDialog(null, "You answered correctly");//Tell them they got it correct
                score++;//Increment their score.
            } else {//If they got it wrong
                JOptionPane.showMessageDialog(null, "You answered incorrectly. The answer is: " + q.getChoices()[q.getCorrectAnswer()]);
                //Tell them they got it wrong and what the correct answer is.
            }
        }

        JOptionPane.showMessageDialog(null, "Your score is: " + score + "/" + maxScore);//At the end, tell them their score
    }

    /**
     * Asks a question and returns whether the player got it correct.
     *
     * @param question
     * @return
     */
    private boolean ask(Question question) {
        //Shows a dialog with the question and answers.
        int choice = JOptionPane.showOptionDialog(
                null,
                question.getQuestion(),
                lang.getDisplayName(),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                question.getChoices(),
                question.getChoices()[0]);

        //Checks to see if the answer is correct. This is determined by the answer variable in the question object.
        if (choice == question.getCorrectAnswer()) {
            return true;
        }

        return false;
    }

    /**
     * Just makes everything look nice. You don't have to worry about this.
     */
    private void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (/**What java look and feel*/
                        "Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            //Very unlikely to happen
        }
    }

    /**
     * Shows the welcome dialogs and so on.
     */
    private void showOpeningDialogs() {
        name = JOptionPane.showInputDialog(null, "Welcome.\nPlease enter you name:");//Gets the users name.

        String[] langs = new String[]{Language.JAVA.getDisplayName(), Language.CPP.getDisplayName()};
        int opt = JOptionPane.showOptionDialog(null, "Please chose your language", "Menu", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, langs, langs[0]);//Gets the language the user chose.

        //Set the language depending on the users choice.
        switch (opt) {
            case JOptionPane.YES_OPTION:
                lang = Language.JAVA;
                break;
            default:
                lang = Language.CPP;
        }

        //The instructions.
        JOptionPane.showMessageDialog(null, "Hello " + name + "\nWelcome to the " + lang.getDisplayName() + " Quiz!");
        JOptionPane.showMessageDialog(null, "1. Please read the questions carefully \n2. Answer all the question \n3. Scores will be computed after the quiz \n4. No Cheating!", "RULES", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "This Quiz consist of \n 1. Multiple Choice");

        //Do they want to continue
        int begin = JOptionPane.showOptionDialog(null, "Are you ready to begin?", "Menu", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Yes", "No"}, "Yes");

        if (begin != JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Gets a random question for a language
     *
     * @param lang the language
     * @return a random question
     */
    private Question getRandomQuestion(Language lang) {
        switch (lang) {
            case JAVA://If the language is java, choose a java question.
                int random = new Random().nextInt(JAVA_QUESTIONS.length);
                return JAVA_QUESTIONS[random];
            case CPP://Else choose a C++ question.
                random = new Random().nextInt(CPP_QUESTIONS.length);
                return CPP_QUESTIONS[random];
        }

        return null;
    }

    public static void main(String[] args) {
        Quiz q = new Quiz();//Just starts the application.
    }

    /**
     * This class holds a question, the correct answer and the choices.
     */
    private static final class Question {

        /**
         * The question being asked
         */
        private final String question;

        /**
         * The correct choice. The index of the choices array.
         */
        private final int correctAnswer;

        /**
         * The 4 choices the player can choose
         */
        private final String[] choices;

        public Question(String question, int correctAnswer, String... choices) {
            if (question == null) {
                throw new NullPointerException("The question cannot be null");
            }

            if (correctAnswer < 1 || correctAnswer > 4) {
                throw new IllegalArgumentException("Correct answer must be between 0 and 5 (1 to 4)");
            }

            if (choices == null) {
                throw new NullPointerException("choices cannot be null");
            }

            if (choices.length != 4) {
                throw new NullPointerException("Choices must have 4 options");
            }

            this.question = question;
            this.correctAnswer = correctAnswer - 1;
            this.choices = choices;
        }

        /**
         * @return the question
         */
        public String getQuestion() {
            return question;
        }

        /**
         * @return the correctAnswer
         */
        public int getCorrectAnswer() {
            return correctAnswer;
        }

        /**
         * @return the choices
         */
        public String[] getChoices() {
            return choices;
        }
    }

    /**
     * Which language we're using
     */
    private enum Language {

        /**
         * The Java programming language
         */
        JAVA("Java"),
        /**
         * The C++ programming language
         */
        CPP("C++");

        //The display name for the language
        private final String displayName;

        Language(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
}