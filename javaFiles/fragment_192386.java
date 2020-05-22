userinput = JOptionPane.showInputDialog( "Enter a number. " , null);
for (int i = 0; i < userInput.length(); i++)
{
    char c = userInput.charAt(i);
    if ((c-'0') % 2 == 1)
    {
        sum += (c-'0');
    }
 }
 System.out.println( sum );