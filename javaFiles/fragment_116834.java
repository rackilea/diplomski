class Generator {
    List<String> number = Arrays.asList("1", "2", "3", "4", "5", "6");
    int n = 0;

    Generator() {
        Collections.shuffle(number);
    }

    String next() {
        return number.get(n++);
    }