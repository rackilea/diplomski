Comparator<Team> pointComparator = new Comparator<Team>() {
  @Override
  public int compare(Team o1, Team o2) {
    return -Integer.compare(o1.getPoints(), o2.getPoints());
  }
}