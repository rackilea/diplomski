public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==b)//button b
        B.setBackground(Color.PINK);
    else if(e.getSource()==a)//button a
        A.setBackground(Color.BLACK);
}