public class Navigator {

  private final Route theRoute;
  private final MapView theMap;

  public Navigator(Route inRoute, MapView theMap) {
    theRoute = inRoute;
    this.theMap = theMap;
  }

  public void setup() {
    theRoute.calculateRoute();
  }

  public void display() {
    theMap.plot(theRoute);
  }

}