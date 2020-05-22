double probFailureWithin(int steps, int age, double lambda) {
  return 
    1.0 - 
    Math.exp(-lambda * age * steps) * 
    Math.exp(-lambda * steps * (steps + 1) / 2.0);
}