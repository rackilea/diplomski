Intent intent = getIntent();
String name1 = intent.getStringExtra("player1Name");
TextView name1 = (TextView) findViewById(R.id.name1);
name1.setText(message);

String name1 = intent2.getStringExtra("player2Name");
TextView name2 = (TextView) findViewById(R.id.name2);
name2.setText(name1 ;