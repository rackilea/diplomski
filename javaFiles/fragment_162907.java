int[] tal = {3, 8, 5, 8, 2, 3, 9, 12, 21};
int max = tal[0];
int previous = Integer.MIN_VALUE;
for (int i = 1; i < tal.length; i++) {
    if (tal[i] > max) {
        previous = max;
        max = tal[i];
    }
    else if (tal[i] > previous) {
        previous = tal[i];
    }
}
System.out.println("Biggest: "+ max);
System.out.println("2nd Biggest: "+ previous);