double temp = power2(base, n/2); // T(n/2)
if (n%2 == 0) {
  return power2(temp, 2); // O(1) by looking at the base case
} else {
  return power2(temp, 2) * base; // O(1) by looking at the base case
}