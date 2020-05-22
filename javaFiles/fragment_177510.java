private void recursiveSeatPerson(String snippet, List<String> p, List<String> s) {
  if (p.size() > 1) {
    for (int i = 0; i < s.size(); i++) {
      String combination = snippet + p.get(0) + s.get(i) + ", ";

      List<String> new_s = new ArrayList<>();
      for (int index_s = 0; index_s < s.size(); index_s++) {
        if (index_s != i) {
          new_s.add(s.get(index_s));
        }
      }
      List<String> new_p = new ArrayList<>();
      for (int index_p = 1; index_p < p.size(); index_p++) {
        new_p.add(p.get(index_p));
      }
      recursiveSeatPerson(combination, new_p, new_s);
    }
  } else {
    System.out.println(snippet + p.get(0)+s.get(0) + " ");
  }
}