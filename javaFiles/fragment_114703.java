public class ListMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent evt) {
        Object source = evt.getSource();
        if (source instanceof JList) {
            JList list = (JList)source;
        }
    }
}