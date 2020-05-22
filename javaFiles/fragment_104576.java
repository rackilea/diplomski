SimpleAttributeSet green = new SimpleAttributeSet();
StyleConstants.setFontFamily(green, "Courier New Italic");
StyleConstants.setForeground(green, Color.GREEN);

//  Add some text

try
{
    textPane.getDocument().insertString(0, "green text with Courier font", green);
}
catch(Exception e) {}