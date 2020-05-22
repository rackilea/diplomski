.subscribe(integer -> {
    TextView tv = (TextView) findViewById(R.id.textView1);
    tv.setText(String.valueOf(integer));
}, error -> {}, () -> {
    TextView tv = (TextView) findViewById(R.id.textView1);
    tv.setText("");