Comparator<String> stringComparator = (o1, o2) -> {
  int o1FirstNum = Integer.parseInt(o1.substring(o1.indexOf('_') + 1, o1.indexOf('(')));
  int o2FirstNum = Integer.parseInt(o2.substring(o2.indexOf('_') + 1, o2.indexOf('(')));

  if (o1FirstNum == o2FirstNum) {
    int o1SecondNum = Integer.parseInt(o1.substring(o1.indexOf('(') + 1, o1.indexOf(')')));
    int o2SecondNum = Integer.parseInt(o2.substring(o2.indexOf('(') + 1, o2.indexOf(')')));
    return o1SecondNum - o2SecondNum;
  }

  return o1FirstNum - o2FirstNum;
};

SortedSet<String> fileNames = new TreeSet<String>(stringComparator);