class SQLQueryRunnable implements Runnable {
    private String query;
    public SQLQueryRunnable(String query) {
        this.query = query;
    }
    public void run() {
        // execute query
    }
}