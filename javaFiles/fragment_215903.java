class Page {
    private String data;
    private boolean hasNext;

    public Page(String data, boolean hasNext) {
        this.data = data;
        this.hasNext = hasNext;
    }

    public String getData() {
        return data;
    }

    public boolean hasNext() {
        return hasNext;
    }

}