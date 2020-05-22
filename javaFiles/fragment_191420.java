class RightMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

        if (SwingUtilities.isRightMouseButton(e)) {

            int row = tree.getClosestRowForLocation(e.getX(), e.getY());
            tree.setSelectionRow(row);
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    ...

    //other overrides

    ...
 };