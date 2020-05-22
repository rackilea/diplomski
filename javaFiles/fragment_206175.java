double probFailureWithin(int steps, int age, double lambda) {
  return 
    1.0 - 
    Math.exp(-lambda * age * steps) * 
    Math.exp(-lambda * steps * (steps + 1) / 2.0);
}

boolean randFailureWithin(int steps, int age, double lambda) {
  for (int k = 1; k <= steps; k++) {
    double failProb = 1 - Math.exp(-lambda * (age + k));
    if (Math.random() < failProb) {
      return true;
    }
  }
  return false;
}

double bruteforceFailureWithin(int steps, int age, double lambda) {
  double nonFailureProb = 1.0;
  for (int k = 1; k <= steps; k++) {
    nonFailureProb *= Math.exp(-lambda * (age + k));
  }
  return 1.0 - nonFailureProb;
}

void runExperiment(int steps, int age, double lambda, int reps) {
  int numFailures = 0;
  for (int rep = 0; rep < reps; rep++) {
    if (randFailureWithin(steps, age, lambda)) {
      numFailures++;
    }
  }
  double empiricalProb = numFailures / (double)reps;
  double predictedProb = probFailureWithin(steps, age, lambda);
  double bruteforceProb = bruteforceFailureWithin(steps, age, lambda);
  System.out.println(
    "a = " + age + 
    " l = " + lambda + 
    " s = " + steps +
    " Empirical: " + empiricalProb + 
    " Predicted: " + predictedProb + 
    " BruteForce: " + bruteforceProb
  );
}

void runExperiments(int reps) {
  for (double lambda : new double[]{0.7, 0.5, 0.1, 0.01, 0.0001}) {
    for (int age : new int[]{0, 1, 10, 1000, 10000}) {
      for (int steps : new int[]{0, 1, 10, 1000, 10000}) {
         runExperiment(steps, age, lambda, reps);
      }
    }
  }
}