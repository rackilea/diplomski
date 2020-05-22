public class Task {
    private JTextArea ta;
    public Task(JTextArea ta) {
        this.ta = ta;
    }

    public void execute() {
        Thread t = new Thread(new Runnable() {
            // perform the long operation
            // at the end, update the text area, in the EDT
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ta.append("finished");
                }
            });
        }
        t.start();
    }
}