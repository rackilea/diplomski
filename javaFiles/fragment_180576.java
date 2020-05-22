public void resetScore(View view){
    score = 0;
    displayResetScore(score);
}

 private void displayResetScore(int resetScore) {
    ResetButton.setText(String.valueOf(score));
}