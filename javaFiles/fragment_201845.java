class myClass {

  public static enum Options {A,B,C};

  private EnumSet optionSet = EnumSet.noneOf(Option.class);

  public setOption(Option o) {
    optionSet.add(o);
  }
  public setOptions(EnumSet addset) {
    optionSet.addAll(addset);
  }

}