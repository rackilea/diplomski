int num;
String s = JOptionPane.showInputDialog("Enter a number please");
while(true)
{
    if(s==null) 
        break; // if you press cancel it will exit
    try {
        num=Integer.parseInt(s);
        break;
    } catch(NumberFormatException ex)
    {
        s = JOptionPane.showInputDialog("Not a number , Try Again");
    }
}