char oth = (a == 'x') ? 'o' : 'x';
String x = (a == 'x') ? "xo" : "ox";

// Construct the two repeating patterns which will alternate
String first = String.join("", Collections.nCopies(b / 2, x));
String second = first;
if (b % 2 == 1) {
    second = new StringBuilder(first).reverse().toString();
    first += a;
    second += oth;
}
for (int i = 0; i < b; i++) {
    System.out.println(i % 2 == 0 ? first : second);
}