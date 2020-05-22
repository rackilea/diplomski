mButton.setOnClickListener(new View.OnClickListener() { 
    public void onClick(View printIt) {
    final TextView mTextView = (TextView) findViewById(R.id.print);
    String hourString = String.valueOf(hour);
    String minString = String.valueOf(minute);
    mTextView.setText(hourString + minString);