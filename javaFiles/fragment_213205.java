Comparator<Team> myComparator = new Comparator() {
   @Override
   public int compare(Team t1, Team t2) {
      int result = t1.getWins() - t2.getWins();
      if (result == 0)
         result = t2.getLosses() - t1.getLosses();
      if (result == 0)
         ... more tests here

      return result;
   }

};