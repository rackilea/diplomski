public void check(String userInput) {
    boolean gotItRight= false;
    ArrayList<String> levelAnswers = answers.getAnswersForLevel(currentLevel);

    if (levelAnswers.contains(userInput.toLowerCase()) {
        messageDisplay.append("\n \n" + userInput + "\n");
        commandInput.setText("");
        messageDisplay.append("\n" + messages.getNextMessage());
        currentLevel++;
        getCurrentLevel();
        gotItRight= true;
        break;
    }
}