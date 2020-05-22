@SuppressWarnings("serial")
public class QuestionViewPanel extends JPanel {
    private Question question; // model for this view
    private JLabel questionLabel;
    private ButtonGroup answersGroup = new ButtonGroup();
    private JButton submitButton = new JButton("Submit");
    private JButton clearAnswerButton = new JButton("Clear Answer");

    public QuestionViewPanel(Question question) {
        this.question = question;

        questionLabel = new JLabel(question.getQuestion());
        questionLabel.setBorder(BorderFactory.createTitledBorder("Question:"));

        JPanel possAnswersPanel = new JPanel(new GridLayout(0, 1));
        possAnswersPanel.setBorder(BorderFactory.createTitledBorder("Possible Answers:"));
        for (String possAnswer : question.getPossibleAnswers()) {
            JRadioButton rBtn = new JRadioButton(possAnswer);
            rBtn.setActionCommand(possAnswer);
            answersGroup.add(rBtn);
            possAnswersPanel.add(rBtn);
        }

        clearAnswerButton.setMnemonic(KeyEvent.VK_C);
        clearAnswerButton.addActionListener(e -> answersGroup.clearSelection());
        submitButton.setMnemonic(KeyEvent.VK_S);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(submitButton);
        bottomPanel.add(clearAnswerButton);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(questionLabel, BorderLayout.PAGE_START);
        add(possAnswersPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public Question getQuestion() {
        return question;
    }

    public boolean testAnswer() {
        boolean result = false;
        ButtonModel model = answersGroup.getSelection();
        if (model != null) {
            String possibleAnswer = model.getActionCommand();
            result = question.test(possibleAnswer);
        }
        return result;
    }

}