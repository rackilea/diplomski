PopupFactory.setSharedInstance(new PopupFactory() 
{
    @Override
    public Popup getPopup(Component owner, final Component contents, int x, int y) throws IllegalArgumentException
    {
        Popup popup = super.getPopup(owner, contents, x, y);
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                contents.repaint();
            }
        });
        return popup;
    }
});