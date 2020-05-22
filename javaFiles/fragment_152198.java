public static class Builder {

    public Pizza build() {    // Notice this method
      return new Pizza(this);
    }
  }

  private Pizza(Builder builder) {  // Notice this Constructor
    size = builder.size;
    cheese = builder.cheese;
    pepperoni = builder.pepperoni;
    bacon = builder.bacon;
  }