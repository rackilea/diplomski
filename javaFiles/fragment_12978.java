public class LabelUpdater implements Runnable {
    private JLabel statusLabel;
    ...

    @Override
    public void run() {
        ...
        statusLabel.setText("Ok Button clicked.");
    }
}