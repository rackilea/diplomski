for (String prime : new ArrayList<String>(primes)) {
        if (!prime.matches("[2357][1379]*[37]")) {
            System.out.println(prime);
            primes.remove(prime);
        }
    }