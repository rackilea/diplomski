frame = new JFrame();
frame.setVisible(true);
frame.setSize(250, 250);
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

GridLayout layout = new GridLayout();
frame.setLayout(layout);

ActionListener actionListener = new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Hello");
    }
};

for (int i = 0; i < 10; ++i)
{
    JButton button = new JButton("A");
    button.addActionListener(actionListener);
    frame.getContentPane().add(button);
}