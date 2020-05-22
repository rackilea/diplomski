while(it.hasNext()) {
    Integer currentNum = it.next();
    if (!circularPrimes.contains(currentNum)) {
        Set<Integer> perms = getAllRotations(currentNum); 

        if(primes.containsAll(perms)) {
            circularPrimes.addAll(perms); 
        }
    }

}