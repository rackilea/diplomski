class Zcount {
    private int xCount = 0;
    private int yCount = 0;

    public Zcount accept(Z z) {
        if (z.x == x1)
            xCount++;
        if (z.y == y1)
            yCount++;
        return this;
    }

    public Zcount combine(ZCount other) {
        xCount += other.xCount;
        yCount += other.yCount;
        return this;
    }
}

Zcount count = list.stream().collect(Zcount::new, Zcount::accept, Zcount::combine);