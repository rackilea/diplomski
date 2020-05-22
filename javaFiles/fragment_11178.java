public void actionPerformed(ActionEvent e)
{
    for(int i = 0; i<=29; i++)
    {
        if(e.getSource() == gB[i])
        {
            System.out.println(i);
        }
    }
}