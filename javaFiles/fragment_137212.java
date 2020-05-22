class Data implements Comparable<Data> {
    double FirstNumber;
    double SecondNumber;

    public Data( double FirstNumber, double SecondNumber) {
        this.FirstNumber = FirstNumber;
        this.SecondNumber = SecondNumber;
    }

    @Override
    public int compareTo(Data o) {
        if (this.SecondNumber < o.SecondNumber) {
            return 1;
        } else {
            return -1;
        }
    }
}