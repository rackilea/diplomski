Map<Integer, AwardYearSource> map = new LinkedHashMap<>();
for (AwardYearSource ays : list) {
  map.put(ays.getYear(), ays);
}
list.clear();
list.addAll(map.values());