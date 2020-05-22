else {
    //questionBox.setText(R.string.wrong_answer);
    //scoreEndBox.setText(scoreNum + "");
    setContentView(R.layout.end_page);
    TextView scoreEndBox = (TextView)findViewById(R.id.scoreEnd);
    scoreEndBox.setText(scoreNum + "");
    scoreNum = 0;
}