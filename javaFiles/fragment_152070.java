/**
 * Iterates all bit patterns containing the specified number of bits.
 *
 * See "Compute the lexicographically next bit permutation"
 * http://graphics.stanford.edu/~seander/bithacks.html#NextBitPermutation
 *
 * @author OldCurmudgeon
 */
public class BitPattern implements Iterable<BigInteger> {

    // Useful stuff.

    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = ONE.add(ONE);
    // How many bits to work with.
    private final int bits;
    // Value to stop at. 2^max_bits.
    private final BigInteger stop;
    // Should we invert the output.
    private final boolean not;

    // All patterns of that many bits up to the specified number of bits - invberting if required.
    public BitPattern(int bits, int max, boolean not) {
        this.bits = bits;
        this.stop = TWO.pow(max);
        this.not = not;
    }

    // All patterns of that many bits up to the specified number of bits.
    public BitPattern(int bits, int max) {
        this(bits, max, false);
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return new BitPatternIterator();
    }

    /*
     * From the link:
     *
     * Suppose we have a pattern of N bits set to 1 in an integer and
     * we want the next permutation of N 1 bits in a lexicographical sense.
     *
     * For example, if N is 3 and the bit pattern is 00010011, the next patterns would be
     * 00010101, 00010110, 00011001,
     * 00011010, 00011100, 00100011,
     * and so forth.
     *
     * The following is a fast way to compute the next permutation.
     */
    private class BitPatternIterator implements Iterator<BigInteger> {

        // Next to deliver - initially 2^n - 1

        BigInteger next = TWO.pow(bits).subtract(ONE);
        // The last one we delivered.
        BigInteger last;

        @Override
        public boolean hasNext() {
            if (next == null) {
            // Next one!
                // t gets v's least significant 0 bits set to 1
                // unsigned int t = v | (v - 1);
                BigInteger t = last.or(last.subtract(BigInteger.ONE));
                // Silly optimisation.
                BigInteger notT = t.not();
            // Next set to 1 the most significant bit to change,
                // set to 0 the least significant ones, and add the necessary 1 bits.
                // w = (t + 1) | (((~t & -~t) - 1) >> (__builtin_ctz(v) + 1));
                // The __builtin_ctz(v) GNU C compiler intrinsic for x86 CPUs returns the number of trailing zeros.
                next = t.add(ONE).or(notT.and(notT.negate()).subtract(ONE).shiftRight(last.getLowestSetBit() + 1));
                if (next.compareTo(stop) >= 0) {
                    // Dont go there.
                    next = null;
                }
            }
            return next != null;
        }

        @Override
        public BigInteger next() {
            last = hasNext() ? next : null;
            next = null;
            return not ? last.not() : last;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public String toString() {
            return next != null ? next.toString(2) : last != null ? last.toString(2) : "";
        }

    }

    public static void main(String[] args) {
        // Generates 1, 10, 100. One bit set in a 3-bit number.
        int bits = 1;
        int max = 3;

        System.out.println("BitPattern(" + bits + ", " + max + ")");
        for (BigInteger i : new BitPattern(bits, max)) {
            System.out.println(i.toString(2));
        }
    }
}