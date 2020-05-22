// at JFrame class
addWindowListener(new CloseListener());

// reusable Close Listener
public class CloseListener extends WindowAdapter {
    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }
}