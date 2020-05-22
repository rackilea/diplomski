List<String> l = new ArrayList<>();
while (true) {
    for (int i = 0; i < 100_100; i++) {
            l.add("" + i);
    }
    l = new ArrayList<>();
}