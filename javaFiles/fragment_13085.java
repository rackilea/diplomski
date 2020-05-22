for(int i=0;i<10;i++)
{
    if(i%3==0)
    {
        y+=50; x=40;
    }
    buttons[i]=new JButton((i+1)+"");
    buttons[i].setSize(50, 50);
    buttons[i].setLocation(x, y);

    int butNum = i;
    buttons[i].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentPlayer = turnCount % 2 == 0 ? "X" : "O";
            buttons[butNum].setText(currentPlayer);
            buttons[butNum].setForeground(Color.BLUE);
            buttons[butNum].setFont(new Font("Arial", Font.PLAIN, 30));
            buttons[butNum].setMargin(new Insets(0, 0, 0, 0));
            buttons[butNum].setEnabled(false);
            turnCount++;
        }
    });

    myForm.add(buttons[i]);
    x+=50;
}