List<String> s = new ArrayList<String>();
  for (String x : xs) {
    for (String y : ys) {
      for (String z : zs) {
        s.add(doSomething(x, y, z));
      }
    }
  }