else {
    //questionBox.setText(R.string.wrong_answer);
    //scoreEndBox.setText(scoreNum + "");
    setContentView(R.layout.end_page); //this is the reason
    scoreEndBox.setText(scoreNum + "");
    scoreNum = 0;
}