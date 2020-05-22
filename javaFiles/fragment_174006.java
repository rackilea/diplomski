Random rand = new Random(); // in the class or something?
Set<Pair> generatePairs(int[] alphabet, int num) {
    Set<Pair> set = new HashSet<>();
    int size = alphabet.length * alphabet.length; // pretend it's a matrix 
    while(set.size() < num) {
        int both = random.nextInt(size); // only works up to alphabet.length < 2^15
        int apos = both % alphabet.length;
        int bpos = both / alphabet.length;
        int a = alphabet[a];
        int b = alphabet[b];
        Pair pair = new Pair(a,b);
        set.add(pair);
    }
    return set;
}