public enum dataTypeOptions {

    FLOAT, NUMBER, CHAR, VARCHAR2, DATE, TIMESTAMP_6("TIMESTAMP(6)");
    private String stringRepresentation;

    dataTypeOptions() { //default behaviour, use the enum constant identifier
        this.stringRepresentation = this.name();
    }

    dataTypeOptions(String s) {
        this.stringRepresentation = s;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

};