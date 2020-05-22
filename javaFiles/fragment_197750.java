private int activeButton =1;
Button Button1;
Button Button2;
Button Button3;
Button Button4;
Button Button5;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_workout_one);

    //setting up the buttons
    Button1 = (Button) findViewById(R.id.button_1);
    Button2 = (Button) findViewById(R.id.button_2);
    Button3 = (Button) findViewById(R.id.button_3);
    Button4 = (Button) findViewById(R.id.button_4);
    Button5 = (Button) findViewById(R.id.button_5);
    buttonClickHandler(Button1, Button2, Button3, Button4, Button5);
}

private void buttonClickHandler(Button a, Button b, Button c, Button d, Button e){ 
    switch(activeButton++){
        case 1:
            //method to make the button animate etc
            makeButtonActive(a);
            break;
        case 2:
            makeButtonActive(b);
            break;
        case 3:
            makeButtonActive(c);
            break;
        case 4:
            makeButtonActive(d);
            break;
        case 5:
            makeButtonActive(e);
            break;
    }
}

private void makeButtonActive(Button bu){
    //setting up the animation
    Animation mAnimation = new AlphaAnimation(1, 0);
    mAnimation.setDuration(1000);
    mAnimation.setInterpolator(new LinearInterpolator());
    mAnimation.setRepeatCount(Animation.INFINITE);
    mAnimation.setRepeatMode(Animation.REVERSE);
    bu.startAnimation(mAnimation);
    bu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //providing the after click stuff
            v.clearAnimation();
            v.setBackgroundColor(0xFF00FF00);
            v.setFocusable(false);
            v.setFocusableInTouchMode(false);
            v.setClickable(false);
            v.setEnabled(false);
            buttonClickHandler(Button1, Button2, Button3, Button4, Button5);
        }
    });
}