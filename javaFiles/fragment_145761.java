button1.setText("Button1");
button2.setText("Button2");
button3.setText("Button2");

JPanel panel = (JPanel)e.getComponent();

if (panel.getSize().width < panel.getPreferredSize().width)
{
    button1.setText("");
    button2.setText("");
    button3.setText("");
}