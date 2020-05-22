public void addLedigeDage(List<Date> newLedigeDage) {
  for (Date date : newLedigeDage) {
    Month month = new Month(date);
    if (!ledigeDageMap.containsKey(month)) {
      ledigeDageMap.put(month, new ArrayList<>());
    }
    ledigeDageMap.get(month).add(date);
  }
}