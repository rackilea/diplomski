@Override
public void mouseEntered(MouseEvent e) 
{
    if(takingTurn)
    {
        if(e.getX() > 50 && e.getX() < 250)
        {
            mouseOverTile[0] = true;
            System.out.println(mouseOverTile[0]);
            repaint();
        }
    }
}