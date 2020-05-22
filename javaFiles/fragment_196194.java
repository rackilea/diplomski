private static final String TEXT_COLOR = "TEXT_COLOR";
private String textColor;
private Button btnObj;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    btnObj = findViewById(<button id>);
    if (savedInstanceState != null) {
        textColor = savedInstanceState.getString(TEXT_COLOR);
        btnObj.setTextColor(Color.parseColor(textColor));
    } 
    ...
}

@Override
public void onClick(View v) {
    if (!((Button) v).getText().toString().equals("")) {
        return;
    }

    if (playerOneMove) {
        ((Button) v).setText("A");
         textColor = "#e8e5e5";
        ((Button) v).setTextColor(Color.parseColor(textColor));
    } else {
        ((Button) v).setText("Z");
        textColor = "#737374";
        ((Button) v).setTextColor(Color.parseColor(textColor));
    } 

    ...

}

@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    savedInstanceState.putString(TEXT_COLOR, textColor);
    super.onSaveInstanceState(savedInstanceState);
}