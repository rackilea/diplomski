class C {
   private Set<A> mySet;

   public void addA(A a) {
      mySet.add(a);
      a.setParent(this);
   }

   public void setMySet(Set<A> subset) {
      mySet = new HashSet<A>(subSet);
      for(A a in subSet) {
         a.setParent(this);
      }
   }

}