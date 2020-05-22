private void a(String... argsArr) {
    List<String> newList = new ArrayList<>();
    newList.add("foo");
    newList.addAll(Arrays.asList(argsArr));

    b(newList.toArray(new String[newList.size()]));
}