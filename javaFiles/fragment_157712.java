private boolean btn1Pressed = false;
private boolean btn2Pressed = false;

static final String STATE_BUTTON1 = "button_1";
static final String STATE_BUTTON2 = "button_2";

@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    // Save the buttons current state
    savedInstanceState.putBoolean(STATE_BUTTON1, btn1Pressed);
    savedInstanceState.putBoolean(STATE_BUTTON2, btn2Pressed);

    super.onSaveInstanceState(savedInstanceState);
}