public static void createGrid(JPanel panel, int numberOfRows, int numberOfColumns)
{
    panel.setLayout(new GridLayout(numberOfRows, numberOfColumns));
    for (int c = 0; c < numberOfColumns; c++)
    {
        for (int r = 0; r < numberOfRows; r++)
        {
        JButton button = new JButton();
        button.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
            //Add your code here for action event
            }
        });
        panel.add(button);
        }
    }
}