Arrays.sort(pairArray, new Comparator<Pair>() {
   @Override
   public int compare(Pair p1, Pair p2) {
       return p1.getL().compareTo(p2.getL());
   }
});