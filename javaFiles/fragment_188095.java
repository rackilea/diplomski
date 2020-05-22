public class DisposeWindowAction extends AbstractAction {

    private Window window;

    public DisposeWindowAction(Window window) {
        this.window = window;
        putValue(NAME, "Dispose");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0));
    }

    public Window getWindow() {
        return window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getWindow().dispose();
    }

}