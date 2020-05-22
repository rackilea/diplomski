double value = 0.00009;
while (true) {
    String nextDown = String.format("%.5f", Math.nextDown(value));
    String nextUp   = String.format("%.5f", Math.nextUp(value));
    if (! nextDown.equals(nextUp))
        break; // loss of precision to 5 decimals
    System.out.printf("Good: %.5f%n", value);
    value = value * 10 + 0.00009;
}
System.out.printf("Bad: %.5f%n", value);