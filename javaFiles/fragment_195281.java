import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;

public int randomIntWithBias(int min, int max, double p0, double delta){
    if (p0 < 0.0)
        throw new Exception("Negative initial probability");        
    int N = max - min + 1; // total number of items to sample

    double[] p = new double[N]; // probabilities
    int[] items = new int[N]; // items

    double sum = 0.0; // total probabilities summed
    for(int k = 0; k != N; ++k) { // fill arrays
        p[k] = p0 + k*delta;
        sum += p[k];
        items[k] = min + k;
    }

    if (delta < 0.0) { // when delta negative we could get negative probabilities
       if (p[N-1] < 0.0) // check only last probability
           throw new Exception("Negative probability");
    }

    for(int k = 0; k != N; ++k) { // Normalize probabilities
        p[k] /= sum;
    }

    EnumeratedIntegerDistribution rng = new EnumeratedIntegerDistribution(items, p);

    return rng.sample();
}