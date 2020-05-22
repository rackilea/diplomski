class Pair implements Comparable<Pair>{

    int number, index;

    @Override
    public int compareTo(Pair other){
        return Integer.compare(number, other.number);
    }
}