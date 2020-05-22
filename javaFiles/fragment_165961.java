class Intermediate implements Comparable<Intermediate> {
    private Integer[] array;
    public Intermediate(Integer[] arr) { array = arr; }
    public boolean equals(Object o) { 
        return (o instanceof Intermediate) &&
            array[1] == ((Intermediate)o).array[1];
    }
    public int compareTo(Intermediate i) {
        return Integer.compare(array[0], i.array[0]);
    }
    public Integer[] toTarget() { return array; }
}