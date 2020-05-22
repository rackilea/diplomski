JButton[] colorButtons = new JButton[9]; // initialize array
for (int i = 0; i < colorButtons.length; i++) {
   JButton button = ... // initialize button each time thru

   // do any common setup on the buttons

   colorButtons[i] = button; // put the button in the array.
}