Bundle extras = intent.getExtras();
String bigText = null;
if (extras != null && extras.containsKey("bigText")) {
    bigText = extras.getString("bigText");
}
TextView t2 = (TextView) findViewById(R.id.textView);
t2.setText(bigText);