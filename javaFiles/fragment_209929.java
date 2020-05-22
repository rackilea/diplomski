JButton[][] btns = new JButton[5][5];
for(int i=0; i<5; i++)
{
    for(int j=0;j<5;j++)
    {
        btns[i][j] = new JButton("Button"+i+j);
    }
}