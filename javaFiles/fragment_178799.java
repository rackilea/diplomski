public enum ServerTask {
    RUN_CYME_EXPORT("Run CYME Export");
    private final String value;
    private ServerTask(String aValue) {this.value = aValue;}
    public String value() {return value;}
}