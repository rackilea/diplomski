interface Band {
  String getName();
  void doStuff();
  ...
}

enum BandsVI implements Band {
  V, I;
  public String getName() { return toString(); }
  public void doStuff() { /* do stuff as appropriate for these bands */ }
  ...
}

enum BandsJHK implements Band {
  J, H, K;
  public String getName() { return toString(); }
  public void doStuff() { /* do stuff as appropriate for these bands */ }
  ...
}