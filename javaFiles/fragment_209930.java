GroupAction groupAction = new GroupAction();
JButton[][] btns = new JButton[5][5];
for(int i=0; i<5; i++)
{
    for(int j=0;j<5;j++)
    {
        btns[i][j] = new JButton(groupAction);
        // This is important as the button will want
        // to use the Action properties to configure itself
        btns[i][j].setText("Button"+i+j);
    }
}