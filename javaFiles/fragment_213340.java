public static void main(String[] args) throws IOException, ClassNotFoundException {
    final List<String> strings = new ArrayList<>();
    strings.add("adaaa");
    strings.add("bbaaa");
    strings.add("dcaaaa");
    strings.add("zaaaaa");
    Collections.sort(strings, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Character.compare(o1.charAt(1), o2.charAt(1));
        }
    });
    System.out.println(strings);
}