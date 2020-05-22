if (nskip <= available()) {
        long n = 0;
        // The loop below can iterate several times,
        // only the first call is guaranteed to be non-blocking. 
        while (n < nskip) { 
        nskip = nskip - n;
        n = skip(nskip);
        }