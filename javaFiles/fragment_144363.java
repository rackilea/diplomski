public List<Animal> findByKeyword(String keyword, boolean excludeDead) {
   // the original code here
   if (excludeDead) {
       // additional code in case excludeDead is true
   }
}

public List<Animal> findByKeyword(String keyword) {
    return findByKeyword(keyword, false);
}