private Double chekcer() {
  int myNumber = 900;
  double distance = Math.abs(aList.get(0)- myNumber);
  int idx = 0;
  for (int c = 1; c < aList.size(); c++) {
    double cdistance = Math.abs(aList.get(c) - myNumber);
    if (cdistance < distance) {
        idx = c;
        distance = cdistance;
    }
  }
  Log("",...);
  return aList.get(idx);
}