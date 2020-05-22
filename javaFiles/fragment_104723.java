@Override
public void actionPerformed(ActionEvent e)
{
    String color1 = (String)combo1.getSelectedItem();
    String color2 = (String)combo2.getSelectedItem();
    // Possibly check if either color is 'null' here

    if (color1.equals("blue") && color2.equals("yellow"))
    {
        message.setText("green");
    }
    ...
}