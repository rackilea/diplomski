public enum Numbers {
    One("1"), Two("2"), Three("3");

    private String digit;

    Numbers(String digit) { this.digit = digit; }

    public String getDigit() { return digit; }
}