class Star {
  private List<? extends Band> bandTypes;
  public Star(List<? extends Band> bandTypes) { this.bandTypes = bandTypes; }
  public void printBandNames() {
    for (Band b : bandTypes)
      System.out.println(b.getName());
  }
  ...
}

...
Star star1 = new Star(Arrays.asList(BandsVI.values()));
Star star3 = new Star(Arrays.asList(new Band[]{BandsVI.V, BandsVI.I, BandsJHK.K}));
...