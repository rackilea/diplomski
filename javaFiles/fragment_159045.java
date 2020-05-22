public void mouseClicked(MouseEvent arg0) 
{
    clickX = arg0.getX();
    clickY = arg0.getY();

    Card discarded = getCard(clickX,clickY);
    b.players[p].discardCard(discarded);

    // The card has been discarded, I can start my timer again.
    timer.start();
}