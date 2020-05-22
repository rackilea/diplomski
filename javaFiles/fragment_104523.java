new Accumulator<Integer>() {
    @Override
    public Integer accumulate(Integer t1, Integer t2) {
        return t1 + t2;
    }
};