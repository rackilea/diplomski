list.addMouseListener( new MouseAdapter()
{
    public void mousePressed(MouseEvent e)
    {
        if ( SwingUtilities.isRightMouseButton(e) )
        {
            JList list = (JList)e.getSource();
            int row = list.locationToIndex(e.getPoint());
            list.setSelectedIndex(row);
        }
    }

});