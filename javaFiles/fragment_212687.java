if (lqc == null) {
    lqc = new ListenerQuestionChooser(this, this);
}

if (savedInstanceState != null) {
    this.loadSettings(savedInstanceState);
}

if (finQuest == null) {
    try {
        finQuest = findViewById(R.id.btn_finansfer);
        finQuest.setOnClickListener(lqc);
        if (ListenerQuestionChooser.getCorrectAnswer() > 0) {
            finQuest.setVisibility(View.VISIBLE);
        } else {
            finQuest.setVisibility(View.INVISIBLE);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

if (labelPoints == null) {
    labelPoints = findViewById(R.id.total_score);
    score = findViewById(R.id.text_points);
    try {
        ss = new StringSetter(this);
        if (getLangFlag() == 0) {
            labelPoints.setVisibility(View.INVISIBLE);
            score.setVisibility(View.INVISIBLE);
        } else {
            score.setText(String.valueOf(getPoints()));
            labelPoints.setText(ss.podesiPromenljivu(brPoena, getLanguage()));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}