public final class WeirdCounter {
    private int[]  bases;
    private char[] buf;
    private int    idx;
    public WeirdCounter(int ... bases) {
        if (bases.length == 0)
            throw new IllegalArgumentException("No bases");
        for (int base : bases)
            if (base < 1 || base > 10)
                throw new IllegalArgumentException("Invalid base:" + base);
        this.bases = bases.clone();
        this.buf = new char[bases.length];
        Arrays.fill(this.buf, '0');
        this.idx = this.buf.length - 1;
    }
    public String next() {
        while (this.idx >= 0) {
            char digit = this.buf[this.idx];
            if (++digit < '0' + this.bases[this.idx]) {
                this.buf[this.idx] = digit;
                if (this.idx < this.buf.length - 1)
                    this.idx++;
                return new String(this.buf);
            }
            this.buf[this.idx--] = '0';
        }
        return null;
    }
}