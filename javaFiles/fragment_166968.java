public static final int BUTTON_A = 1;
public static final int BUTTON_B = 2;
public static final int BUTTON_X = 4;
public static final int BUTTON_Y = 8;

int buttonState = BUTTON_A | BUTTON_X; // A & X are pressed!

if ((buttonState & BUTTON_B) != 0) {   // B is pressed...
   ...
}