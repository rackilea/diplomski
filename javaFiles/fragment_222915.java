Map<String, Integer> freq = new HashMap<String, Integer>();
for (String s: names):
    first_name = Arrays.asList(s.split()).get(0).toLowerCase()
    int count = freq.containsKey(name) ? freq.get(name) : 0;
    freq.put(name, count + 1);

Arrays.sort(names, new Comparator<String>() {
  public int compare(String s1, String s2) {
    int c = freq.get(Arrays.asList(s1.split()).get(0).toLowerCase()) - Arrays.asList(s2.split()).get(0).toLowerCase();
    return c;
  }
});