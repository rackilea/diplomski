public void rightanswer(View view){

    score += Integer.parseInt(scored.getText()); //add them right there

    scored.setText(String.valueOf(score));
    Intent intent = new Intent(this, Page6.class);
    intent.putExtra("ta_score",String.valueOf(score));
    startActivity(intent);
    ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
        0, view.getWidth(), view.getHeight());
    startActivity(intent, options.toBundle());