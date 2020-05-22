private String name;

public String getName()
{
 if (name == null)
  askForName();   
 return name;
}

private void askForName()
{
 name = JOptionPane.showInputDialog("What is your name?");
}