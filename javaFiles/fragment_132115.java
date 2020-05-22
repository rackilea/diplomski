public static void main(String[] args) {
    List<String> test = new ArrayList<>(new Test().getTestData());
    System.out.println(test);
    test.sort(Collator.getInstance(Locale.ENGLISH));
    System.out.println(test);
}