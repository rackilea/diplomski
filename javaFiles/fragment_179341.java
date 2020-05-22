interface Overridable {
  Stuff getStuff();
}

class SeriourExample implements Overridable {
  @Override SeriousStuff getStuff() { ... }
}