List<String> expirations = Arrays.asList(new String[] {"20180329", "20180615", "20180119",
    "20180316", "20180921", "20180216", "20171222", "20180105"});

Set<String> sortedSet = new TreeSet<>(expirations);

for (Iterator<String> i = sortedSet.iterator(); i.hasNext();) {
  String item = i.next();
  System.out.println(item);
}