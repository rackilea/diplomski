private void fahrTextKeyTyped(java.awt.event.KeyEvent evt)
{   
    try
    {                             
        int fahr = Integer.parseInt(fahrText.getText());
        int cels = (int)(fahr / 1.8 - 32);
        celsiusText.setText(cels + "");
    }
    catch(NumberFormatException ex)
    {
        //Error handling code here, i.e. informative message to the user
    }
}