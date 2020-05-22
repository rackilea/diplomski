class Job {
    private int id;
    private String category;
    private int no;

    public Job(int id, String category, int no) {
        this.id = id;
        this.category = category;
        this.no = no;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Job)) return false;
        return category.equals(((Job)obj).category);
    }

    @Override
    public int hashCode() {
        return category.hashCode();
    }

    @Override
    public String toString() {
        return "[" + id + ", " + category + ", " + no + "]\n";
    }
}