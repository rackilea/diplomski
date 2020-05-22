public class TextFieldFrame extends JFrame
{
     private JTextField field = ...; // init in your constructor

     public void notifyButtonPressed()
     {
         field.setText("Yes man!! The button is pressed by the user!");
     }
}