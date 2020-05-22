public void render() {
   if(TouchButton.lastPressIndex > 0) { // Making sure a button is actually pressed.
        TouchButton pressedButton = holdsButtons.get(TouchButton.lastPressIndex);
        // Now you know which button was pressed.
        TouchButton.lastPressIndex = 0; // Reset the value.
    }
}