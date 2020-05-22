int partyIn;
try
{
   partyIn = Integer.parseInt(ans);
}
catch (NumberFormatException e)
{
   JOptionPane.showMessageDialog(null, "What you entered was not a number: " + ans);
}