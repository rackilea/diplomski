String[] titles = { "MyQuestions","     MyAnswers","     Calendar","     Setting","     Send FeedBack"};
TextView[] textViews = new TextView[titles.length];
for(int i=0; i < titles.length; i++){    // I'd suggest to use lenght propery rather than 5 value
   TextView textView = new TextView(context);
   textView.setText(athenaPanel.getTitle());
   textViews[i] = textView;
}