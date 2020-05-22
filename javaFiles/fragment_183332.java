public class ContactSystem extends JFrame implements ActionListener 
{
  .....
  jbtAdd.addActionListener(this);
  jbtFirst.addActionListener(this);
  .....

  @Override
  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if(actionCommand.equals("Add")) {
        //do add stuff
    } else if (actionCommand.equals("First")) {
        // move first
    }
  }
}