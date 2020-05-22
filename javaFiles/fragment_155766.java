aJLabel.addMouseListener(new MouseAdapter()
{
    @Override
    public void mouseEntered(MouseEvent aE)
    {
        Font aFont = aJLabel.getFont();
        aJLabel.setFont(aFont.deriveFont((float) aFont.getSize() + 5));
    }

    @Override
    public void mouseExited(MouseEvent aE)
    {
        Font aFont = aJLabel.getFont();
        aJLabel.setFont(aFont.deriveFont((float) aFont.getSize() - 5));
    }

});