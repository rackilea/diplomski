public void check(String userInput) {
    boolean gotItRight= false;
    ArrayList<String> levelAnswers = answers.getAnswersForLevel(currentLevel);
    for (String answer : levelAnswers) {
        if (userInput.toLowerCase().equals(answer)) {
            messageDisplay.append("\n \n" + userInput + "\n");
            commandInput.setText("");
            messageDisplay.append("\n" + messages.getNextMessage());
            currentLevel++;
            getCurrentLevel();
            gotItRight= true;
            break;
        }
    }
    if (!gotItRight) {
        notValid();
    }
}