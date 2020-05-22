// use ArrayList, it is very easy to handle and comes with all necessary methods as Payam already said
ArrayList<String> list = new ArrayList<>();
list.add("1");
list.add("2");
list.add("3");

// this is the actual solution:
for (int i = 1; i < list.size(); i += 2) {
    list.add(i, ",");
}

// and this is just for testing (printing) the list
for (String s : list) {
    System.out.print("'"+s + "' ");
}