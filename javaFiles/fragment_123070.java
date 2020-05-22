public void actionPerformed(ActionEvent ae) {
    String answer = answerText.getText();
    int answerint = Integer.parseInt(answer);
    if (one + two == answerint) {
        correctcounter++;
        System.out.println("correct");
    } else if (one - two == answerint) {
        correctcounter++;
        System.out.println("correct");
    } else if (one * two == answerint) {
        correctcounter++;
        System.out.println("correct");
    } else if (one / two == answerint) {
        correctcounter++;
        System.out.println("correct");
    } else {
        wrongcounter++;
        System.out.println("wrong");
    }
    one = generator.nextInt(11);
    two = generator.nextInt(11);
    firstnum.setText("" + one);
    randomOP.setText("" + ops[generator.nextInt(4)]);
    secondnum.setText("" + two);
}