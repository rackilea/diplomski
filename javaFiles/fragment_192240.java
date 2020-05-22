public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    addToList(list);
    System.out.println(list);
}

private static void addToList(List list) {
    list.add(1L);
    list.add(42);
    list.add("String");
    list.add(new Runnable() {
        @Override
        public void run() {}
    });
}