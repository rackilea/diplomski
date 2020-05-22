public class tstDocumentListener implements DocumentListener
{
    public void changedUpdate(DocumentEvent e) {}       
    public void removeUpdate(DocumentEvent e)
    {
        String newString = "";
        int lengthMe = e.getDocument().getLength();
        try
        {
            newString = e.getDocument().getText(0,lengthMe);

            System.out.println(newString);
        }

        catch(Exception exp)
        {
            System.out.println("Error");
        }
    }
    public void insertUpdate(DocumentEvent e) 
    {
        String newString = "";
        int lengthMe = e.getDocument().getLength();
        try
        {
            newString = e.getDocument().getText(0,lengthMe);

            System.out.println(newString);
        }

        catch(Exception exp)
        {
            System.out.println("Error");
        }
    }
}