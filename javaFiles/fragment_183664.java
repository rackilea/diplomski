Collection<String> col = Arrays.asList("hello", "world");

// Exploiting the fact that collections implement Iterable
for (String s : col)
    System.out.println(s);

// Using iterator explicitly:
Iterator<String> iter = col.iterator();
while (iter.hasNext())
    System.out.println(iter.next());

// Using toArray
System.out.println(Arrays.toString(col.toArray()));

// Using toArray(String[])
System.out.println(Arrays.toString(col.toArray(new String[0])));