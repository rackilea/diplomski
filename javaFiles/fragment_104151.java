ActionListener taskPerformer = new ActionListener() 
{
    int y = 0;

    public void actionPerformed(ActionEvent evt) 
    {
        for(x=0;x<1920;x++)
        {
            image.setRGB(x,y,matrix[x][y]);
        }

        repaint();

        y++;

        if (y >= ???)
            ((Timer)evt.getSource()).stop();
    }
};