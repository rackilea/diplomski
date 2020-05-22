public class Whatever {
    private String text;
    private final Object TEXT_LOCK = new Object();

    public void setText(final String newText) {
        synchronized (TEXT_LOCK) {
            text = newText;
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                someLabel.setText(newText);
            }
        });
    }

    public String getText() {
        synchronized (TEXT_LOCK) {
            return text;
        }
    }
}