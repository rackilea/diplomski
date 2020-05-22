class OrderedTask implements Comparable<OrderedTask> {

    private final Integer index;
    private final String line;

    public OrderedTask(Integer index, String line) {
        this.index = index;
        this.line = line;
    }


    @Override
    public int compareTo(OrderedTask o) {
        return index < o.getIndex() ? -1 : index == o.getIndex() ? 0 : 1;
    }

    public Integer getIndex() {
        return index;
    }

    public String getLine() {
        return line;
    }    
}