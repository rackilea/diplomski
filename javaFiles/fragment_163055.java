// Define the basic colors you want to use:

SimpleAttributeSet colorCode1 = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.RED);

SimpleAttributeSet colorCode2 = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.YELLOW);

//  Add some text

JTextPane textPane = new JTextPane();
StyledDocument doc = textPane.getStyledDocument();

try
{
    doc.insertString(doc.getLength(), "\nA line of text", colorCode1);
    doc.insertString(doc.getLength(), "\nAnother line of text", colorCode2);
}
catch(Exception e) {}