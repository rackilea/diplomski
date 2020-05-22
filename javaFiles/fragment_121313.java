while (f <= 100000)
    {
        if (isPrime(f)) {
            System.out.println(f + " is a prime number and a Fibonacci Number!");
            fb1 = fb2;
            fb2 = f;                    
            f = fb1 + fb2;
        }
    }