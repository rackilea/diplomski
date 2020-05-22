public static void main(String[] args) {
    String pattern = "([-+]?[0-9]*,?[0-9]+)";
    String x = "1,23132";

    System.out.println(x.matches(pattern));
}