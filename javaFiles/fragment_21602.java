public class MyPopupTextArea extends JTextArea {
    /*...*/
    public Point getPopupLocation(MouseEvent evt) {
        Rectangle rectangle = textArea.get(now_focus).modelToView(_caret);

        Point p = rectangle.getLoction();
        p.y += rectangle.height;

        return p;
    }
}