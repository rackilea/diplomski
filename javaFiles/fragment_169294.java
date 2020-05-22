public final class Quark {

  public Quark(String aName, double aMass){
    fName = aName;
    fMass = aMass;
  }

  //PRIVATE

  //WITHOUT redundant initialization to default values
  //private String fName;
  //private double fMass;

  //WITH redundant initialization to default values
  private String fName = null;
  private double fMass = 0.0d;
}