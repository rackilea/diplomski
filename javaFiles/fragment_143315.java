String dpt, salary, name;
Manager[] emp = new Manager[3];

for (int i=0; i<emp.length; i++)
{
  emp[i] = new Manager(); // Create the object
  name = JOptionPane.showInputDialog("Enter Name");
  emp[i].setName(name);
}