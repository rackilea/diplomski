Bundle extras = getIntent().getExtras();

String intentString;
if(extras != null) {
    intentString = extras.getString("TimeValue");
} else {
    intentString = "Default String";
}
TextView timeText = (TextView)findViewById(R.id.timeText);
timeText.setText(intentString);