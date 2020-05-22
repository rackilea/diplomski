int n = 0;
for (String s: array) {
  if (s.length > 2 && mapping.containsKey(s)) n++;
}
String[] bigEnough = new String[n];
n = 0;
for (String s: array) {
  if (s.length <= 2) continue;
  bigEnough[n++] = map.get(s);
}