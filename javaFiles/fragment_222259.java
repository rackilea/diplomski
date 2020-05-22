List<String> l1 = new ArrayList<>();
l1.add("A");
l1.add("B");
List<String> l2 = new ArrayList<>();
l2.add("0");
l2.add("1");
l2.add("2");
List<String> l3 = new ArrayList<>();
l3.add("w");
l3.add("x");
l3.add("y");
l3.add("z");
List<List<String>> combs = Utils.createCombinations(l1, l2, l3);
for (List<String> l : combs) {
    System.out.println("l = " + l);
}