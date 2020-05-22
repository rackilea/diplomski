//In onCreate()
Intent intent = getIntent();
text1 = intent.getStringExtra("KEY1");
text2 = intent.getStringExtra("KEY2")
tv1.setText(text1);
tv2.setText(text2);