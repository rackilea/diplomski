class Random96 extends Random {
    int count = 0;
    ExposedRandom extra48bits;

    class ExposedRandom extends Random {
        public int next(int bits) {    // Expose the next-method.
            return super.next(bits);
        }
    }

    @Override
    protected int next(int bits) {
        if (count++ == 0)
            extra48bits = new ExposedRandom();
        return super.next(bits) ^ extra48bits.next(bits) << 1;
    }
}