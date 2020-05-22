public void displayServerAnswer(String answer){
    TextView textView = (TextView)findViewById(R.id.mainTextView);
    try {
        textView.setText(answer);
    }
    catch(Exception e){
      e.printStackTrace();
    }
}