public enum Table {
    CREATE("CREATE TABLE"),
    ALTER("ALTER TABLE");

    private String cmd;

    Table(String cmd) {
       this.cmd = cmd;
    }

    @Override
    public String toString() {
        return cmd;
    }
}