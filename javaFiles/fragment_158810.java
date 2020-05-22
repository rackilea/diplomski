double root = Math.sqrt(num);
for (int x = 1; x < root; x++) {
    if (num % x == 0) {
        counter += 2;
    }
}