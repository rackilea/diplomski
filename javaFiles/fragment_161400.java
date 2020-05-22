public static long factor(long rc) {

   long n = rc;

   List<Long> pfactors = new ArrayList<Long>();

    for (long i = 2 ; i <= n ;  i++) {

        while (n % i == 0) {
            pfactors.add(i);

            n = n / i;

        }

    }

    return pfactors.get(pfactors.size() - 1);
}