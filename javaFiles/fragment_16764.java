public static void main(String[] args) {
    String[] arr = new String[]{"i", "came", "i", "saw", "i", "left"};

    Set<String> set = Arrays.asList(arr).stream().collect(Collectors.toSet());

    System.out.println(set.size() + "  distinct words: " + set);
}