private class Pair implements Comparable<Pair> {

    public int first;
    public int second;

    public Pair (int a, int b){
        this.first = a;
        this.second = b;

    }

    public int compareTo (Pair o){
        return second < o.second ? -1 : (second == o.second ? 0 : 1);
    }
}