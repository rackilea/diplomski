public double ave() {
    return aveRec(head, 0, 0);
}

private double aveRec(Node n, long sum, int count) {
    if (n == null) {
        if (count == 0) {
            // what to return if the linked list is empty?
            return 0;
        }
        return (sum * 1D) / count;
    }
    if (n.getData() % 2 == 0) {
        return aveRec(n.getNext(), sum + n.getData(), count + 1);
    } else {
        return aveRec(n.getNext(), sum, count);
    }

}