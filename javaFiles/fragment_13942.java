public class Builder {
  // contains regular builder methods
}

public class UnsetBuilder extends Builder {
  public Builder setValue(Object obj) { ... }
}

// the builder constructor actually returns an UnsetBuilder
public static UnsetBuilder builder() { ... }