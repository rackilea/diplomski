public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    list.add("foo");
    list.add("bar");
    String listStringRepr = WordsContainer.getStringRepresentation(list);
    System.out.println(listStringRepr);
}