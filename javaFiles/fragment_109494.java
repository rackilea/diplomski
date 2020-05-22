public MyList(K[] k, V[] v) {
    this.k = k;
    this.v = v;
}


public static void main(String[] args) {
    MyList<Integer,Double> values = new MyList<>(new Integer[0], new Double[0]);
    values.add(1,0.5);
}