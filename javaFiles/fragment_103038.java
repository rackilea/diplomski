@Override
public void actionPerformed(ActionEvent event)
{
    //get the Action Command text from the button
    String action = event.getActionCommand();

    //set the text using the Action Command text
    numberCalc.setText(action);       
}