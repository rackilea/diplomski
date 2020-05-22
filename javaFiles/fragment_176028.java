public static void main(String[] args) throws IOException {
    List<String> strings = Arrays.asList("room1", "foo", "room2", "room100", "room10");
    Collections.sort(strings, new Comparator<String>() {
        public int compare(String o1, String o2) {
            return extractInt(o1) - extractInt(o2);
        }

        int extractInt(String s) {
            String num = s.replaceAll("\\D", "");
            // return 0 if no digits found
            return num.isEmpty() ? 0 : Integer.parseInt(num);
        }
    });
    System.out.println(strings);
}