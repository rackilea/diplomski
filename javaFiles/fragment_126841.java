class SonBuilder {

    private String sonProperty;
    private ParentBuilder parentBuilder = new ParentBuilder();

    public SonBuilder sonProperty(String sonProperty) {
      this.sonProperty = sonProperty;
      return this;
    }

    public SonBuilder parentProperty(int parentPropertyValue) {
      parentBuilder.parentProperty(parentPropertyValue);
      return this;
    }

    public Son build() {
      return new Son(parentBuilder.parentProperty, sonProperty);
    }
}