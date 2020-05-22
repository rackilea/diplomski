long seed = ...
int amount = 100;

Random rnd = new Random(seed);

// Generate sequence of 100 random values, discard 99 and get the last
int val = rnd.ints(100).skip(amount - 1).findFirst().orElse(-1);