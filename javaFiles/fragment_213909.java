double x = 1.23

Map<Double, List<Something>> map = new HashMap<>();
for (;;) {
 List<Something> xValues = null;
if (map.containsKey(x)) {
   xValues = map.get(x);
} else {
  xValues = new ArrayList<>();
  map.put(x, xValues);
}
xValues.add(new Something(Blah, Blah)); 
}