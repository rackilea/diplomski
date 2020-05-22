static class FiboSpliterator implements Spliterator<BigInteger> {
    private final static BigInteger[] STARTING_MATRIX = {
        BigInteger.ONE, BigInteger.ONE, 
        BigInteger.ONE, BigInteger.ZERO};

    private BigInteger[] state; // previous and current numbers
    private int cur; // position
    private final int fence; // max number to cover by this spliterator

    public FiboSpliterator(int max) {
        this(0, max);
    }

    // State is not initialized until traversal
    private FiboSpliterator(int cur, int fence) {
        assert fence >= 0;
        this.cur = cur;
        this.fence = fence;
    }

    // Multiplication of 2x2 matrix, by definition      
    static BigInteger[] multiply(BigInteger[] m1, BigInteger[] m2) {
        return new BigInteger[] {
            m1[0].multiply(m2[0]).add(m1[1].multiply(m2[2])),
            m1[0].multiply(m2[1]).add(m1[1].multiply(m2[3])),
            m1[2].multiply(m2[0]).add(m1[3].multiply(m2[2])),
            m1[2].multiply(m2[1]).add(m1[3].multiply(m2[3]))};
    }

    // Log(n) algorithm to raise 2x2 matrix to n-th power       
    static BigInteger[] power(BigInteger[] m, int n) {
        assert n > 0;
        if(n == 1) {
            return m;
        }
        if(n % 2 == 0) {
            BigInteger[] root = power(m, n/2);
            return multiply(root, root);
        } else {
            return multiply(power(m, n-1), m);
        }
    }

    @Override
    public boolean tryAdvance(Consumer<? super BigInteger> action) {
        if(cur == fence)
            return false; // traversal finished
        if(state == null) {
            // initialize state: done only once
            if(cur == 0) {
                state = new BigInteger[] {BigInteger.ZERO, BigInteger.ONE};
            } else {
                BigInteger[] res = power(STARTING_MATRIX, cur);
                state = new BigInteger[] {res[1], res[0]};
            }
        }
        action.accept(state[1]);
        // update state
        if(++cur < fence) {
            BigInteger next = state[0].add(state[1]);
            state[0] = state[1];
            state[1] = next;
        }
        return true;
    }

    @Override
    public Spliterator<BigInteger> trySplit() {
        if(fence - cur < 2)
            return null;
        int mid = (fence+cur) >>> 1;
        if(mid - cur < 100) {
            // resulting interval is too small:
            // instead of jumping we just store prefix into array
            // and return ArraySpliterator
            BigInteger[] array = new BigInteger[mid-cur];
            for(int i=0; i<array.length; i++) {
                tryAdvance(f -> {});
                array[i] = state[0];
            }
            return Spliterators.spliterator(array, ORDERED | NONNULL | SORTED);
        }
        // Jump to another position
        return new FiboSpliterator(cur, cur = mid);
    }

    @Override
    public long estimateSize() {
        return fence - cur;
    }

    @Override
    public int characteristics() {
        return ORDERED | IMMUTABLE | SIZED| SUBSIZED | NONNULL | SORTED;
    }

    @Override
    public Comparator<? super BigInteger> getComparator() {
        return null; // natural order
    }
}