int totalAttempts= 3; 
private void executeLogin() {

    String userNameStr = userNameTF.getText();
    String passWordStr = passWordTF.getText();

    if (totalAttempts != 0) {
        if (userNameStr == "temp" && passWordStr == "pass") {
            System.out.println("Correct");
        else {
            System.out.println("Incorrect");
            totalAttempts--;

    } else {
        System.out.println("Maximum number of attempts exceeded");
    }
}