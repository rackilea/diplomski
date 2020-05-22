@Override
public void done() {
    try {
        get();
        output.setText("Done!");
    } catch (InterruptedException | ExecutionException ex) {
        ex.printStackTrace();
        output.setText("Bad: " + ex.getMessage());
    }
}