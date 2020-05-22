public enum Database {
    CREATE("CREATE DATABASE");

    private String cmd;

    Database(String cmd) {
       this.cmd = cmd;
    }

    @Override
    public String toString() {
        return cmd;
    }
}