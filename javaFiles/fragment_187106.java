List<Integer> list = new ArrayList<>();
for (int i=0; i < 100; ++i) {
    list.add(i);
}
long seed = System.nanoTime();
Collections.shuffle(list, new Random(seed));

// now here is your loop
for (int i=0; i < 100; ++i) {
    if (list.get(i) < 40) {
        A();
    }
    else if (list.get(i) < 70) {
        B();
    }
    else {
        C();
    }
}