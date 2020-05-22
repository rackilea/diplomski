private Button button1;
private Button button2; 
....
private Button button10;

...
protected void onCreate(Bundle b) {
    super.onCreate(b);
    button1 = findViewById(R.id.button1);
    ...
    button10 = findViewById(R.id.button10);
    OnClickListener onCL = new OnClickListener . . . //do all of your creation here
    Button[] buttons = {button1, button2, . . . , button10};
    for(Button b : buttons) {
        b.setOnClickListener(onCL);
    }
}