public class StationByNameComparator implements Comparator<Station> {
  @Override
  public int compare(Station left, Station right) {
    String leftName = left.getName();
    String rightName = right.getName();
    return leftName.compareTo(rightName);
  }
}