...
  @JsonIgnore
  private String legNumber;

  @JsonIgnore
  private String origin;

  @JsonIgnore
  private String destination;

  public String getLegNumber() {
    return legNumber;
  }

  public void setLegNumber(final String legNumber) {
    this.legNumber = legNumber;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(final String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(final String destination) {
    this.destination = destination;
  }
...