public class MaritalState {

  private static final String MARRIED = "married";
  private static final String SINGLE = "single";
  private static final String WIDOW = "widow";

  private String state;

  private MaritalState(String state) {
    this.state = state;
  }

  public MaritalState() {
    this.state = "single";
  }

  void marry(Person person, Person mate) {
    if (person.isMarried() || mate.isMarried()) {
      System.out.println("MaritalState status error! At least one of you are married");
    } else {
      person.maritalState = new MaritalState(MARRIED);
      person.mate = mate;
      mate.maritalState = new MaritalState(MARRIED);
      mate.mate = person;
      System.out.println("Congratulations!!! " + person.name + " and " + mate.name + " are married!");
    }
  }

  void divorce(Person person, Person mate) {
    if (person.isMarried() && person.mate == mate) {
      person.maritalState = new MaritalState("divorced");
      System.out.println(person.name + " and " + mate.name + " are getting divorced.");
    } else if (person.isSingle()) {
      System.out.println("You are not married and you cannot get divorced before getting married");
    } else if (person.isWidow()) {
      System.out.println("Your maritalState status is widow, you cannot get divorced.");
    }
  }

  void die(Person person) {
    person.maritalState = new MaritalState("dead");
    person.mate.maritalState = new MaritalState("widow");
    System.out.println("Sorry for your loss, " + person.mate.name + " maritalState status is widow.");
  }

  public boolean isMarried(MaritalState maritalState) {
    return maritalState.state.equals(MARRIED);
  }

  public boolean isSingle(MaritalState maritalState) {
    return maritalState.state.equals(SINGLE);
  }

  public boolean isWidow(MaritalState maritalState) {
    return maritalState.state.equals(WIDOW);
  }

  public String get() {
    return state;
  }
}