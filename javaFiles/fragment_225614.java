public class ExtendedEuclidAlgorithm {
    public static void main(final String[] args) {
        System.out.println("eea(240, 46) = " + apply(BigInteger.valueOf(240), BigInteger.valueOf(46)));
        System.out.println("eea(65, 40) = " + apply(BigInteger.valueOf(65), BigInteger.valueOf(40)));
        System.out.println("eea(1239, 735) = " + apply(BigInteger.valueOf(1239), BigInteger.valueOf(735)));
    }

    /*
     * extended_euclid(d,s)
          if s = 0
              than return (d,1,0)
          (d',s',t') <-- extended_euclid(s, d mod s)
          return (d',t',s' - (d div s)t')
     */
    public static Triple apply(final BigInteger a, final BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new Triple(a, BigInteger.ONE, BigInteger.ZERO);
        } else {
            final Triple extension = apply(b, a.mod(b));
            return new Triple(extension.d, extension.t, extension.s.subtract(a.divide(b).multiply(extension.t)));
        }
    }


    private static class Triple {
        public final BigInteger d;
        public final BigInteger s;
        public final BigInteger t;
        private Triple(final BigInteger d, final BigInteger s, final BigInteger t) {
            this.d = d;
            this.s = s;
            this.t = t;
        }
        @Override
        public String toString() {
            return "Triple{" +
                    "d=" + d +
                    ", s=" + s +
                    ", t=" + t +
                    '}';
        }
    }
}