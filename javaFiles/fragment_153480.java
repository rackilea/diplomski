class GridPoints {
    private final int size;

    public GridPoints(int size) {
        this.size = size;
    }

    public int[] get(int i) {
        return new int[] {
                (i % size) + 1,
                (i / size) + 1
        };
    }
}

public void test() {
    GridPoints g = new GridPoints(10);
    for ( int i = 0; i < 100; i++) {
        System.out.println(Arrays.toString(g.get(i)));
    }
}