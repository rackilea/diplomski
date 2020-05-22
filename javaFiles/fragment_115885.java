public class Grid implements ActionListener, KeyListener, KeyCodes {
    private final GenericStack<JTextField> stack = new GenericStack<JTextField>();

    private void calculate() {
        while (stack.size() > 0) {
            JTextField w = stack.pop();
            System.out.println("stack element " + w.getText());
        }
    }
}