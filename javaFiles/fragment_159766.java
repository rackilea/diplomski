private static final String command_cbo1 = "ComboBox1";
// ...

public class YourClass implements ItemListener, ActionListener
{
    // ...

    public YourClass()
    {
        // ...
        qntbox1.addActionListener(this);
        qntbox1.setActionCommand(command_cbo1);
        // ...
    }

    // ...

    public void itemStateChanged(ItemEvent e)        
    {
        // ...
    }

    // ...

    public void actionPerformed(ActionEvent e)
    {
        JComboBox cb = (JComboBox) e.getSource();
        String s = (String) cb.getSelectedItem();

        if(e.getActionCommand().equals(command_cbo1))
        {
            fprice1.setText("" + (Integer.parseInt(price1.getText()) * Integer.parseInt(s)));
        }
        // ...
    }

    // ...
}