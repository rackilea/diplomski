public static void main(String[] args) {
    Box g = new Box();

    g.set("hello again");
    Integer i = (Integer) g.get();

    System.out.println(i + 1);
}