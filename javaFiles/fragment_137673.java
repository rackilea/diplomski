replaceButton.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        //the text you want to replace
        String findText = textField.getText();
        //what you want to replace it with
        String replaceText = textField2.getText();
        //all the text in the text area
        String text = textArea.getText();

        //replace first occurrence of "findText" with "replaceText"
        //returns the altered string
        text = text.replaceFirst(findText, replaceText);
        //set text in textArea to newly updated text
        textArea.setText(text);

    }
});