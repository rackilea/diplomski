public class MyMenuItem extends JMenuItem {

    public MyMenuItem(String text) {
        super(text);
    }

    @Override
    protected void processMouseEvent(MouseEvent evt) {
        if (evt.getID() == MouseEvent.MOUSE_RELEASED  && contains(evt.getPoint())) {
            doClick();
            setArmed(true);
        } else
            super.processMouseEvent(evt);
    }

}