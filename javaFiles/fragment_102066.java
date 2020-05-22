int CharValues['f'-'0'+1] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, ... -1, 10, 11, 12, ...};

if (c < '0' || c > 'f') {
    throw new IllegalArgumentException();
}
int n = CharValues[c-'0'];
if (n < 0) {
    throw new IllegalArgumentException();
}
// n contains the digit value