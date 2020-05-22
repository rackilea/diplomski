public BigInteger() {
    for(int i = 0; i < BigInteger.length; i++) {
        BigInteger[i] = 0;
    }
}

public BigInteger(BigInteger bigInteger) {
    for(int i = 0; i < BigInteger.length; i++) {
        BigInteger[i] = bigInteger[i];
    }
}

public BigInteger(int n) {
    String nstr = n.toString(); // not sure
    int pos = 49;
    for(int i = nstr.length - 1; i >= 0 ; i--) {
        BigInteger[pos] = Integer.parse(nstr [i]); // parse each char, you get the idea
        pos--;
    }
}