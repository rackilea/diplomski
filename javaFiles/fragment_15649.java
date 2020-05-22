int result = 0;
int a = 1;
for (int i = binary.length() - 1; i >= 0; i--) {
    if (binary.charAt(i) == '1') {
        result += a; // this adds 2^k to the result for each '1' digit, since a is initialized
                     // to 2^0 and is multiplied by 2 in each iteration
    }
    a *= 2;
}