this.addMouseListener(new MouseListener()
{

    @Override
    public void mouseClicked(MouseEvent e)
    {
        int column = e.getX() / squareSize;
        int row = e.getY() / squareSize;

        board[column][row] = 1;
    }

    [...] // add the other methods to override

}