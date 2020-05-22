public void inner(List<Integer> list) {
    for (int i = 0; i < 5; i++) {
        if (i % 4 == 0) throw new RuntimeException();
        list.add(i);
    }
}