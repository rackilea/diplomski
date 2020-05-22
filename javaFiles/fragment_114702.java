public class ListMouseListener extends MouseAdapter {
    private JList list;
    public ListMouseListener (JList list) {
        this.list = list;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // Know you're self out with the list instance variable...
    }
}