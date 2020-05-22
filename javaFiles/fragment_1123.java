List<String> primes = new ArrayList<String>();
    primes.add("1");
    primes.add("2");
    primes.add("7");
    primes.add("23");
    primes.add("213");
    primes.add("243");
    primes.add("2113");
    primes.add("2193");
    for (int s = 0; s < primes.size(); ++s) {
        String p = primes.get(s);

        if (!p.matches("[2357][1379]*[37]")) {
            System.out.println(p);
            primes.remove(s);
        }
    }