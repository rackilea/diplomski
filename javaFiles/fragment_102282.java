btn = (Button)findViewById(R.id.button);
btn.setOnClickListener(this);
et = (EditText)findViewById(R.id.editText);
lv=(ListView)findViewById(R.id.listView);
mHelper = new InputDbHelper(this);
updateUI();