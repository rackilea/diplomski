public MyProblematicClass(... variables ...) {
    radius = getRadiusWithCriteria(criteria);
}

private int getRadiusWithCriteria(criteria crit) {
   if(... crit ...) {
      return n;
   } else {
      return 0;
   }
}