static class PopupListener extends MouseAdapter {

    JPopupMenu popup;

    PopupListener(JPopupMenu popupMenu) {
        popup = popupMenu;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        togglePopup(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        togglePopup(e);
    }

    private void togglePopup(MouseEvent e) {
        if (e.isPopupTrigger()) {
            popup.show(e.getComponent(), e.getX(), e.getY());
        } else if (popup.isVisible()) {
            popup.setVisible(false);
        }
    }
}