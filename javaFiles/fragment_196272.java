@SuppressWarnings("serial")
public class QuestionTest extends JPanel {
    // This String likely needs to be changed
    private static final String RESOURCE_PATH = "QuestionsFile.txt";
    private List<Question> questionsList = new ArrayList<>();
    private List<QuestionViewPanel> questionViewList = new ArrayList<>();
    private CardLayout cardLayout = new CardLayout();
    private JPanel questionViewShowPanel = new JPanel(cardLayout);

    public QuestionTest(List<Question> questionsList) {
        this.questionsList = questionsList;
        for (Question question : questionsList) {
            QuestionViewPanel qView = new QuestionViewPanel(question);
            qView.addSubmitListener(new SubmitListener(qView));
            questionViewShowPanel.add(qView, question.getQuestion());
        }
        setLayout(new BorderLayout());
        add(questionViewShowPanel);
    }

    private class SubmitListener implements ActionListener {
        private QuestionViewPanel qView;

        public SubmitListener(QuestionViewPanel qView) {
            this.qView = qView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean result = qView.testAnswer();
            String text = result ? "Correct!" : "Wrong!  The correct answer is: " 
                        + qView.getQuestion().getAnswer();
            JOptionPane.showMessageDialog(qView, text, "Result", JOptionPane.PLAIN_MESSAGE);
            cardLayout.next(questionViewShowPanel);
        }
    }

    private static void createAndShowGui(List<Question> questionsList) {
        QuestionTest mainPanel = new QuestionTest(questionsList);

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);  
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        final List<Question> questionsList = new ArrayList<>();

        InputStream questionsStream = QuestionTest.class.getResourceAsStream(RESOURCE_PATH);
        Scanner scanner = new Scanner(questionsStream);
        String question = "";
        String answer = "";
        List<String> possibleAnswers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();           
            if (line.trim().isEmpty()) {
                if (!question.trim().isEmpty()) {
                    questionsList.add(new Question(question, possibleAnswers, answer));
                    question = "";
                    answer = "";
                    possibleAnswers = new ArrayList<>();
                }
            } else if (question.trim().isEmpty()) {
                question = line;
            } else {
                possibleAnswers.add(line);
                if (answer.trim().isBlank()) {
                    answer = line;
                }
            }
        }
        if (!question.trim().isEmpty()) {
            questionsList.add(new Question(question, possibleAnswers, answer));
            question = "";
            answer = "";
            possibleAnswers = new ArrayList<>();
        }
        if (scanner != null) {
            scanner.close();
        }

        SwingUtilities.invokeLater(() -> createAndShowGui(questionsList));
    }
}