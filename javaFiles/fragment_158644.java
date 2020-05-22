public static <B> void main(String[] args) {
    Map<String, ? extends Collection<B>> map1 = test();
    Map<String, ? extends List<B>> map2 = test();
    Map<String, ArrayList<B>> map3 = test();
}

private static <B> Map<String, ArrayList<B>> test() {
    return null;
}