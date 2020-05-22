public int compare(Record r1, Record r2) {
  // if one field list is longer than the other treat that one as greater
  int lenDiff = r1.getFieldList().size() - r2.getFieldList().size();
  if(lenDiff != 0) return lenDiff;

  // both field lists same length, do lexicographic comparison
  Iterator<Field> it1 = r1.getFieldList().iterator();
  Iterator<Field> it2 = r2.getFieldList().iterator();
  while(it1.hasNext()) {
    Field f1 = it1.next();
    Field f2 = it2.next();
    int diff = f1.getValue().compareTo(f2.getValue());
    if(diff != 0) return diff;
  }

  // all components equal, so both lists equal.
  return 0;
}