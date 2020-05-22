public void ProcessSignInput(View v)
{
Button btn = (Button) v;
String currentInput = inputText.getText().toString();
if(inputText.length() > 0 && !currentInput.equalsIgnoreCase(0))
{
    if(currentInput.charAt(0) == '-'))
    {
        inputText.setText(currentInput.subSequence(1, inputText.length()));
    }
    else
    {
        inputText.setText("-" + currentInput.toString());
    }
}
}