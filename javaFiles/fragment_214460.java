public static void main(String[] args) {
    final String REG_EXPR = "[!\"#$%&'()*+-./:;<=>?@\\^_{|}~`,.\\[\\]–]";
    String description="திகழ்கிறது.@;@;@;@;ஆனால் ஆனால் ";
    String s1 = description.replaceAll(REG_EXPR," ");
    Scanner scanner = new Scanner(s1);
    while (scanner.hasNext()){
        System.out.println("s1 value " + scanner.next());
    }
}