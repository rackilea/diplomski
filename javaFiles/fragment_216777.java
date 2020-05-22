public class Gui extends JFrame
{
    public Gui()
    {
        super("Physics Helper v0.1");
        JButton b = new JButton("Press me!");
        b.addActionListener(new HandlerClass());
        add(b);
        pack();
        setVisible(true);
    }

    public void displayButton(String s)
    {
        System.out.println(s);
    }

    private class HandlerClass implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            displayButton("Press me!");
        }
    }

    public static void main(String[] args)
    {
        new Gui();
    }
}