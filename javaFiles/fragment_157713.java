@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.mains);

    if (savedInstanceState != null) {
        // Restore states of buttons from saved state
        btn1Pressed = savedInstanceState.getBoolean(STATE_BUTTON1, false);
        btn2Pressed = savedInstanceState.getBoolean(STATE_BUTTON2, false);            
    }

    btn1 = (Button)findViewById(R.id.btn01);
    btn1.setOnClickListener(this);
    btn2 = (Button)findViewById(R.id.btn02);
    btn2.setOnClickListener(this);

    if(btn1Pressed){
        changeColor(btn1);
    }

   if(btn2Pressed){
        changeColor(btn2);
    }    
}

private void changeColor(Button b){
    b.setBackgroundColor(Color.RED);
    b.setTextColor(Color.WHITE);
}