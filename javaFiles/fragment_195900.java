public class CustomFocusListener implements FocusListener
{
    @Override
    public void focusGained(FocusEvent e)
    {
        String parseMe = "";
        JTextArea src;
        try 
        {
            src = (JTextArea)e.getSource();
            parseMe = src.getText();
            System.out.println(parseMe);
        }
        catch (ClassCastException ignored)
        {

        }
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        String parseMe = "";
        JTextArea src;
        try 
        {
            src = (JTextArea)e.getSource();
            parseMe = src.getText();
            System.out.println(parseMe);
        }
        catch (ClassCastException ignored)
        {

        }
    }
}