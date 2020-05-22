HashMap<String, Integer> map = new HashMap<>();
map.put("ws", SECONDS_PER_WEEK);
map.put("hs", SECONDS_PER_HOUR);
map.put("ds", SECONDS_PER_DAY);
// ...

String fromTo = fromUnit + toUnit;
results = userNumber * map.get(fromTo);
System.out.printf("There are %,.2f to units", results);
System.out.printf(" in %,d %s.\n", userNumber, userNumber == 1 ?          "from unit" : "from units");