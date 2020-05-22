String passString= "information im sending";
Intent intent = new Intent(this, secondActivity.class);
intent.putExtras("DataKey", passString);
startActivity(intent);

//in your second activity
Intent intent = getIntent();
String recieveString = intent.getStringExtra("DataKey");

//repeat the same in your second activity but this time the string will change
Intent intent = new Intent(this, thirdActivity.class);
intent.putExtras("DataKey", recieveString);
startActivity(intent);

//in your third activity
Intent intent = getIntent();
String recieveString2 = intent.getStringExtra("DataKey");