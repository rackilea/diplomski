EditText number1;
EditText number2;
EditText ergebnis;
public int text1;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rechner);

    number1 = (EditText) findViewById(R.id.nummer1);
    number2 = (EditText) findViewById(R.id.nummer2);
    ergebnis = (EditText) findViewById(R.id.ergebnis);

    addListenerOnButton();
}