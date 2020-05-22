public void nextQuestion() {
    counter++;
    question.setText("");
    bOdgovor1.setText("");
    bOdgovor2.setText("");
    bOdgovor3.setText("");
    bOdgovor4.setText("");
    //reset your next question and all four options here
    rezultat.setText(counter + "/10");
}