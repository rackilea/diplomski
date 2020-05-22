try (Scanner i = new Scanner(System.in)) {
    List<String> list = new ArrayList<>();
    while (true) {
        String next = i.next();

        list.add(next);

        if ("exit".equals(next)) {
            System.out.println("Cyka");
            break;
        }
    }
    return list;
}