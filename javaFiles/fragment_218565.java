textView = findViewById(R.id.tv_bt_msg);
textView.setText("secondNumber");

handler = new Handler();
//Change the textview after 5 seconds
handler.postDelayed(runnable, 5000);