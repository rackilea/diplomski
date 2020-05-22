public class SomeCustomPanel extends JPanel
{
    public SomeCustomPanel
    {
        add( new JLabel("I'm a JLabel") );
        JButton button = new JButton("Switch Panel");
        add(button);
        button.addActionListener(...); // add ActionListener to swap cards
    }
}