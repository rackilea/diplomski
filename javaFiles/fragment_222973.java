int b = inputBytes[p++];
int d = b - '0';
if (0 <= d) {
    if (d <= 9) {
        element = element * 10 + d;
    } else {
        // b == ':'
    }
} else {
    // b == ','
    // add element to the hash; element = 0;
    ...
}
if (p == inputBytesLength) {
    inputBytesLength = in.read(inputBytes);
    if (inputBytesLength == 0) { ... }
    p = 0;
}