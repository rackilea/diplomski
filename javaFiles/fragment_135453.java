public static void main(String[] args) {
    int t = new Scanner(System.in).nextInt();
    IntStream.rangeClosed(1, t)
            .mapToObj(n -> 
                String.join("", Collections.nCopies(t - n, " ")) +
                String.join("", Collections.nCopies(n, "#")))
            .forEach(System.out::println);
}