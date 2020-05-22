public enum Animal 
{
  ELEPHANT(true),
  GIRAFFE(true),
  TURTLE(false),
  SNAKE(false),
  FROG(false);

  private final boolean mammal; 
  private Animal(final boolean mammal) { this.mammal = mammal; }
  public boolean isMammal() { return this.mammal; }
}