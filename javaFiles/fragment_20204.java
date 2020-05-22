/**
 * At this point in time the editing component is added to the table (not documented!) but
 * table's internal cleanup might not yet be ready
 */ 
@Override
public boolean shouldSelectCell(EventObject anEvent) {
    if (anEvent instanceof MouseEvent) {
        redirect((MouseEvent) anEvent);
    }
    return false;
}

private void redirect(final MouseEvent anEvent) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            MouseEvent ev = SwingUtilities.convertMouseEvent(anEvent.getComponent(), anEvent, editor);
            // at this point you have the mouse coordinates in the editor's system
            // do stuff, like f.i. findComponent
            ....
        }
    });
}