`public void addOneForTeamA(View view) {
    scoreTeamA = scoreTeamA + 1;
    displayForTeamA(scoreTeamA);
}`
public void displayForTeamA(int score) {
    TextView scoreView = (TextView) findViewById(R.id.Team_A_Score);
    scoreView.setText(String.valueOf(scoreTeamA));