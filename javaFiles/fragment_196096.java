final Map<String, Object> x = new HashMap<String, Object>();
x.put("x", 1); x.put("y", 2); x.put("z", 3); x.put("w", 4);
System.out.println(x);
final List<Object> vs = new ArrayList<Object>(x.values());
Collections.shuffle(vs);
System.out.println(vs);
final Iterator<Object> vIter = vs.iterator();
for (String k : x.keySet()) x.put(k, vIter.next());
System.out.println(x);