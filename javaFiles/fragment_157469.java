int result = 0;
int digit, multiplier = 1;
int base = b2;
while (base > 0) {
    digit = base % 10;
    base /= 10;
    result += digit * multiplier;
    multiplier *= 10;
}

base = b1;
while (base > 0) {
    digit = base % 10;
    base /= 10;
    result += digit * multiplier;
    multiplier *= 10;
}