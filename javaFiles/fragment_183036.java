int x = 0;
string currTitle = "";
do
{
  currTitle = JOptionPane.showInputDialog(null, "Please enter a book title, or zzz to quit:");
  if(!currTitle.equals("zzz"))
  {
    titleInputs[x] = currTitle;
    authorInputs[x] = JOptionPane.showInputDialog(null, "Please enter " + titleInputs[x] + "'s author's last name: ");
    pageInputs[x] = JOptionPane.showInputDialog(null, "Please enter " + titleInputs[x] + "'s page count: ");
    x = x+1;
  }
} while(!currTitle.equals("zzz")) //if you wanted, you could do: while(!currTitle.equals("zzz") && x < MAX_ARRAY_SIZE) ...obviously after declaring MAX_ARRAY_SIZE somewhere.