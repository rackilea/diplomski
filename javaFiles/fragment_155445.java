public enum Severity {

    DEBUG("Some low-level logging output"), 
    INFO("Informational output"), 
    WARN("A warning"), 
    ERROR("A serious error");

    private String description;

    private Severity(String description) {
        this.description = description;
    }

    public void output(String message) {
        switch (this) {
            case DEBUG:
                // ignore
                break;
            case INFO:
                System.out.println(message);
                break;
            case WARN:
            case ERROR:
                System.err.println(message);
                break;
        }
    }

    public String getDescription() {
        return description;
    }

}