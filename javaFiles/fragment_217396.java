enum Functions {
    INSTANCE;

    public BiFunction<Integer, Integer, Integer> A = (i, j) ->
        i == 0 && j == 0 ? 0 :
        i == 0 ? j :
        j == 0 ? i :
        this.A.apply(i - 1, j - 1) > this.A.apply(i - 1, j) ? this.A.apply(i - 1, j - 1) :
        this.A.apply(i - 1, j);

    public BiFunction<Integer, Integer, String> B = (i, j) ->
        i == 0 || j == 0 ? null :
        this.A.apply(i - 1, j - 1) > this.A.apply(i - 1, j) ? "D" :
        "T";
}