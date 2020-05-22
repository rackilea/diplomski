public static void main(String[] args) {
    String pattern = "^[+-]?[0-9]+$";
    System.out.println("20e48".matches(pattern));
    System.out.println("204-8".matches(pattern));
    System.out.println("+2048".matches(pattern));
    System.out.println("-2048".matches(pattern));
    System.out.println("2048".matches(pattern));
}