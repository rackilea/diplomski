Ordering<People> o = new Ordering<People>() {
    @Override
    public int compare(People left, People right) {
        return Ints.compare(left.getAge(), right.getAge());
    }
};

return o.max(list);