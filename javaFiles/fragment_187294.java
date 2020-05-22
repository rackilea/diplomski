boolean matches = false;
for (long num = i; num >= 14 && !matches; num /= 10) {
  matches = (num % 100) == 14;
}
if (matches) {
  counter += 1;
}