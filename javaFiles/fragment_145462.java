public enum Status {
  YES("Yes"),
  NO("No");

  private final String status;

  private Status(final String status) {
    this.status = status;
  }

  public String value() {
    return this.status;
  }
}