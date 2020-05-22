public class Test  {
  private Map<String, Point> points = new HashMap<>();

  @JsonAnySetter
  public void setPoints(String name, Point value) {
    points.put(name, value);
  }

}