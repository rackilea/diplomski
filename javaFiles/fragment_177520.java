final Map<String, Integer> counts = new HashMap<>();

counts.merge("Test", 1, Integer::sum);
counts.merge("Test", 1, Integer::sum);
counts.merge("Other", 1, Integer::sum);
counts.merge("Other", 1, Integer::sum);
counts.merge("Other", 1, Integer::sum);

System.out.println(counts.getOrDefault("Test", 0));
System.out.println(counts.getOrDefault("Other", 0));
System.out.println(counts.getOrDefault("Another", 0));