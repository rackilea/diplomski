class MyComparator implements Comparator<Sequenceable> {

    @Override
    public int compare(Sequenceable o1, Sequenceable o2) {
        return o2.getSequenceNo() - o1.getSequenceNo();
    }
}