LinearLayout ll;
EditText[] editText;
TextView textView;
String room;
Button save;

private DBHelper dbHelper;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_room_name);
    final SharedPreferences mSharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(getBaseContext());
    String room_number = (mSharedPreferences.getString("room_number",
            ""));

    ll = findViewById(R.id.ll);

    final int num = Integer.valueOf(room_number);

    dbHelper = new DBHelper(this);

    editText = new EditText[num]; 
    for (int i = 0; i < num; i++) {
        editText[i] = new EditText(this);
        editText[i].setHint("Room " + (i + 1) + " Name");

        textView = new TextView(this);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        ll.addView(editText[i]);
        ll.addView(textView);

    }
    save = new Button(this);
    save.setText("save");

    ll.addView(save);

    save.setOnClickListener(v -> {

        for (int j = 0; j < num; j++) {
            if (dbHelper.insertRoom(editText[j].getText().toString())) {
                Toast.makeText(getApplicationContext(), "done",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_LONG).show();
            }
        }

    });
}