list.addMouseListener(new MouseAdapter()
{
    public void mousePressed(MouseEvent e)
    {
        if (SwingUtilities.isRightMouseButton(e))
        {
            JList list = (JList) e.getSource();

            int preferredHeight = list.getPreferredSize().height;
            int mouseHeight = e.getPoint().y;

            if (mouseHeight > preferredHeight)
                return;

            int row = list.locationToIndex(e.getPoint());
            list.setSelectedIndex(row);
            // show JPopupMenu
        }
    }
});