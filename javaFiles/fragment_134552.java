int n <- user input (or other source)
String binaryForm <- empty string
while (n > 0) {
    int res <- n % 2;
    n <- n / 2;
    binaryForm <- res + binaryForm
}