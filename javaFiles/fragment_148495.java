public static void main(String[] args)  {

    System.out.println(chekcer());
}

private static Double chekcer() {
      List<Double>  aList = Arrays.asList(100.33,300.99,600.0,900.44,1200.88,1500.15);
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
      return aList.get(idx);
    }