enum Button {
  A, B, X, Y;
}

Set<Button> buttonState = EnumSet.of(Button.A, Button.X); // A & X are pressed!

if (buttonState.contains(Button.B)) { // B is pressed...
   ...
}