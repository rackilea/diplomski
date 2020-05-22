public class ButtonFrame extends JFrame implements ActionListener
{
     private TextFieldFrame frame;

     public ButtonFrame(TextFieldFrame frame)
     {
         this.frame = frame;
         // init your components and add this as actionlistener to the button
         ....
     }

     public void actionPerformed(ActionEvent evt)
     {
         frame.notifyButtonPressed();
     }
}