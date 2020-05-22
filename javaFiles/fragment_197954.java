RandomDataGenerator generator = new RandomDataGenerator(new Well19937c());
// Unit normal
double normDev = generator.nextGaussian(0, 1);
// mean = 0.5, std dev = 2
double normDev2 = generator.nextGaussian(0.5, 2);
// exponential, mean = 1
double expDev = generator.nextExponential(1);