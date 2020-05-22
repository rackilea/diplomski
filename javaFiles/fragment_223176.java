Object eventSource = event.getSource();
String colorName;
if ( eventSource instanceof JRadioButton ) {
    colorName = ((JRadioButton)eventSource).getName();
    // Now get the color value from the collection, build a Color and change the background.
}