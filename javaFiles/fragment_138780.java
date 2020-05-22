private class MouseHandler extends MouseAdapter
{
    public void mouseClicked(MouseEvent e)
    {
        if(e.getButton() == 1)
        {
            Minefield[r][c].setText("T");
        }
        else if(e.getButton() == 3)
        {
            Minefield[r][c].setText("F");
        }
    }
}