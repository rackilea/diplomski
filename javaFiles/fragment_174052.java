public static int combinations = 1;

public static void main(String[] args) {
    int n = 1200;

    oddPrimeFactors(n).forEach((key, value) -> combinations *= (value + 1));
    combinations--;

    System.out.println(combinations);
}