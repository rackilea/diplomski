final int[] primes = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        // list abbreviated for clarity
        7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919
};

BigInteger result = BigInteger.valueOf(1);
for (int i = 0; i < 1000; i++)
    result = result.multiply(BigInteger.valueOf(primes[i]));
System.out.println(result);