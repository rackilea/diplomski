Random rand = new Random();

int randomNumber = rand.nextInt();

button.addActionListener(new ActionListener() {
    public void ActionPerformed(ActionEvent e) {
        String answer = answerField.getText();
        checkAnswer(answer);
    }
});

void checkAnswer(String answer) {
    if(answer.equals(randomNumber.toString()) {
        doSomething();
    }
    else {
        doSomethingElse();
    }
}