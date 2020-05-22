public static void main(String[] args)
{
    JFrame frame = new JFrame();

    JPanel panel = new JPanel(new GridLayout(9, 12, 5, 5));
    panel.setBounds(10, 11, 800, 600);
    frame.getContentPane().add(panel);

    JButton[][] buttons = new JButton[9][12];
    char [] numberList = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    // board
    for (int r = 0; r < 9; r++)
    {
        for (int c = 0; c < 12; c++)
        {
            buttons[r][c] = new JButton("" + (c + 1) + numberList[r]);
            buttons[r][c].setBackground(Color.WHITE);
            panel.add(buttons[r][c]);
        }

    }

    frame.setContentPane(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}