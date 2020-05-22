List<String> ls = new ArrayList<>();
ls.add("Hello");
ls.add("World");
ls.add("Pair");
ls.add("Words");
ls.add("Another");
ls.add("Pair");

for (int i = 0; i < (ls.size() - 1); i = i + 2) {
    ListIterator<String> iter = ls.listIterator(i);
    System.out.println("First: " + iter.next() +
                       ", Second: " + iter.next());
}