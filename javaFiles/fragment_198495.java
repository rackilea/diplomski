int find(int[] t, int min) {
    int s = 0;
    int e = t.length-1;

    if (t[e] >= min) return e;

    while (true) {
        int x = (s+e) / 2;
        if (x == t.length-1) return t.length-1;
        if (t[x] >= min && t[x+1] < min) return x;

        if (t[x] < min) e = x;
        else s = x;
    }
}