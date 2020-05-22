class TextsParam {
  private String service;
  private String webdomain;

  // Getters and setters ...

  @Override 
  public boolean equals(Object obj) {
    if(obj == null) { return false; }
    if(obj == this) { return true; }
    if(obj.getClass() != getClass()) {
      return false;
    }
    TextsParam other = (TextsParam) obj;
    return new EqualsBuilder()
             .appendSuper(super.equals(obj))
             .append(service, other.service)
             .append(webdomain, other.webdomain)
             .isEquals();
  }

  @Override
  public int hashCode() {
    // you pick a hard-coded, randomly chosen, non-zero, odd number
    // ideally different for each class
    return new HashCodeBuilder(17, 37)
        .append(service)
        .append(webdomain).
        .toHashCode();
  }

}

class TextsResult {
  private String id;
  private String name;
  private String body;

  // Getters and setters ...
}