public static void innerJoinHash(List<SportsMan> sportsMans, List<Sport> sportList) {
  Set set = new HashSet();  
  if (sportsMans.size() < sportList.size()) {
        set.addAll(sportsMans)
    } else {
        set.addAll(sportList);
    }
  }