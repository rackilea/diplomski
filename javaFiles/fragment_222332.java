// First find the number of prime factors

int factorsCount = 0;
    int originalN = n;
    while (n > 1) {
       int p = findLowestPrimeFactor(n);
       n /= p;
       factorsCount++;
    }

    // Now create the Array of the appropriate size 

    int[] factors = new int[factorsCount];

    // Finally do the iteration from the first step again, but now filling the array.
    n = originalN;
    int k = 0;
    while (n > 1) {
       int p = findLowestPrimeFactor(n);
       factors[k] = p;
       k++;
       n = n / p;
    }

    return factors;