long[][] values = {
    { 233L, 333L },
    { 377L, 477L },
    { 610L, 710L }
};

// Select a random index
int index = ThreadLocalRandom.current().nextInt(0, values.length);

// Determine lower and upper bounds
long min = values[index][0];
long max = values[index][1];
long rnd = ThreadLocalRandom.current().nextLong(min, max);