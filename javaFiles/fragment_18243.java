public enum Singleton {

    INSTANCE("The one and only");

    private String description;

    private Singleton(String description) {
      this.description = description;
    }

    @Override
    public String toString() {
      return description;
    }

  }