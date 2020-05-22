public static void main(String[] args) {

    String min = Arrays.stream(args)
             .min(String::compareTo)
           .orElse("<none>");

    System.out.println(min);
}