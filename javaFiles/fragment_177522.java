final Counter<String> counts = new Counter<>();

counts.add("Test");
counts.add("Test");
counts.add("Other");
counts.add("Other");
counts.add("Other");

System.out.println(counts.count("Test"));
System.out.println(counts.count("Other"));
System.out.println(counts.count("Another"));