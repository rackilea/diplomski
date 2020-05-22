class Konsola {
    int i = 0;
    String s = null;

    public Konsola(String str, int i, int j, String t, int k, int l) {
        this.s = str;
        this.i = i;
    }

    public String toString() {
        return s + "  " + i;
    }
}