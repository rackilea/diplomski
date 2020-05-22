class Location {
    private String state = "TX";

    public String getState() {
        return state;
    }

    /**
     * backward compatibility
     */
    public String getSt8() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}