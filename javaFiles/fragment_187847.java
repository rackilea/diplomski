frame = new JFrame();
frame.setVisible(true);
frame.setSize(250, 250);
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

GridLayout layout = new GridLayout();
frame.setLayout(layout);

for (int i = 0; i < 10; ++i)
    frame.getContentPane().add(new JButton("A"));

Component[] components = frame.getContentPane().getComponents();
ActionListener actionListener = new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Hello");
    }
};

for (Component component : components)
{
    if (component instanceof JButton)
    {
        ((JButton) component).addActionListener(actionListener);
    }
}