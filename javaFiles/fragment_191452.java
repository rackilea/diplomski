public static void main(String[] args) {

    String min = Arrays.stream(args)
            .min(String::compareTo)
        .orElse("<none>");

    if (!Arrays.stream(args)
            .allMatch(x-> x.equals(min))) {
        System.out.println(min);
    } else {
        System.out.println("All are equal.");
    }
}