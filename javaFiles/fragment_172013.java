List<Integer> indexes = new ArrayList<>();
for (int idx = haystack.indexOf(needle);
     idx != -1;
     idx = haystack.indexOf(needle, idx + 1)) {
  indexes.add(idx);
}