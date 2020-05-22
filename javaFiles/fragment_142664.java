List<String> ls = new ArrayList<>();
ls.add("Hello");
ls.add("World");
ls.add("Pair");
ls.add("Words");
ls.add("Another");
ls.add("Pair");

for (int i = 0; i < (ls.size() - 1); i = i + 2) {
    System.out.println("First: " + ls.get(i) +
                       ", Second: " + ls.get(i + 1));
}