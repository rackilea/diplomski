Map<String, List<Integer>> userScores = new LinkedHashMap<String, List<Integer>>();

String user1 = "Bob";
List scores1 = new ArrayList<Integer>();
scores1.add(5);
scores1.add(10);
scores1.add(15);

userScores.put(user1, scores1);

...
...

String user4 = "Rob";
List scores4 = new ArrayList<Integer>();
scores4.add(2);
scores4.add(3);
scores4.add(4);

userScores.put(user4, scores4);