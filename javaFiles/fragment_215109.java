public class ScrollTest extends JFrame
{
    public ScrollTest()
    {
        super("Overlap issues!");
        JPanel panel = new JPanel();
        //Insets insets = panel.getInsets();
        //insets.set(5, 5, 5, 25);
        //insets.set(top, left, bottom, right);
        panel.setLayout(new GridLayout(100,0));

        for(int b=0;b<100;++b)
        {
            panel.add(new JButton("Small overlap here ->"));
        }

        JScrollPane scrollpane = new JScrollPane(panel);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollpane);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new ScrollTest();
    }
}