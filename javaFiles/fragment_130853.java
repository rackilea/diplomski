public class SearchQuery extends Thread {
    private SearchField f;
    public SearchQuery(JTextField f) {
        this.f = f;
    }

    public void run() {
        // do the query here
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                f.updateData(results);
            }
        });
    }
}