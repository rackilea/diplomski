class m extends s implements Serializable {
    int k;
    int l;

    public m() {
    }

    public m(int i, int j, int k, int l) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
    }

    private static class MProxy implements Serializable {

        int i;
        int j;
        int k;
        int l;

        public MProxy(m point) {
            this.i = point.getI();
            this.j = point.getJ();
            this.k = point.getK();
            this.l = point.getL();
        }

        private Object readResolve() {
            return new m(i, j, k, l);
        }

    }

    private Object writeReplace() {
        return new MProxy(this);
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int fun() {
        return 2;
    }
}