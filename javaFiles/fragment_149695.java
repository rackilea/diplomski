public enum Type
{
  AMPHIBIAN,
  MAMMAL,
  REPTILE,
  BIRD
}

public enum Animal 
{
  ELEPHANT(Type.MAMMAL),
  GIRAFFE(Type.MAMMAL),
  TURTLE(Type.REPTILE),
  SNAKE(Type.REPTILE),
  FROG(Type.AMPHIBIAN);

  private final Type type; 
  private Animal(final Type type) { this.type = type; }
  public boolean isMammal() { return this.type == Type.MAMMAL; }
  public boolean isAmphibian() { return this.type == Type.AMPHIBIAN; }
  public boolean isReptile() { return this.type == Type.REPTILE; }
  // etc...
}