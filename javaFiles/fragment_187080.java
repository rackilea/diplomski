class Star<T extends Enum<T> & Band> {
  private Class<T> bandType;
  public Star(Class<T> bandType) { this.bandType = bandType; }
  public void printBandNames() {
    for (Band b : bandType.getEnumConstants())
      System.out.println(b.getName());
  }
  public void doStuffOnAllBands() {
    for (Band b : bandType.getEnumConstants())
      b.doStuff();
  }
}
...
Star<BandsVI> star1 = new Star<BandsVI>(BandsVI.class);
Star<BandsJHK> star2 = new Star<BandsJHK>(BandsJHK.class);
star1.printBandNames(); // prints V I
star2.printBandNames(); // prints J H K