LinearLayout playGame = (LinearLayout) findViewById(R.id.container_blue);
TextView temp;
TextView[] textViews = new TextView[numberForbiddenWords];
for(int i = 0; i < numberForbiddenWords; i++) {
    temp = new TextView(this);
    temp.setText("TextView " + String.valueOf(i));
    temp.setId(i);
    temp.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

    playGame.addView(temp);
    textViews[i] = temp;
}