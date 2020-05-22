// Assume no wraparound will ever occur due to overflow.
HashFunc h = x -> x + 1;
HashFunc g = y -> y + 2;
h(0) = 1 // No other input value results in --> 1
g(0) = 2 // No other input value results in --> 2
// These must have been orthogonal hash functions.

// Now for some non-orthogonal hash functions:
// Let the domain be integers only.
HashFunc j = x -> ceil(abs(x / 2));
HashFunc k = x -> ceil(sqrt(x));
j(0) = 0 // Unique result
k(0) = 0 // Unique result
j(1) = j(2) = 1
k(1) = 1 != k(2) = 2 
// k(1) results in a unique value, but it isn't unique for j.
// These cannot be orthogonal hash functions.