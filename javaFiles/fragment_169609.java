public class OperatorAction implements ActionListener
{
    int calcOperation = 0;
    int currentCalc;
    private int operator;
    // How to make 


    public OperatorAction(int operation)
    {
        operator = operation;
    }

    public void actionPerformed(ActionEvent event)
    {
        String text = SimpleCalc.instance.getText();
        currentCalc = text != null ? Integer.parseInt(text) : 0; 
        calcOperation = operator;
    }
}