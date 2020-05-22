class K implements Comparable<K> {
    @Override
    public int compareTo( K o) {
        return 0;
    }
}

class K2 implements Comparable<K2> {
    @Override
    public int compareTo(K2 o) { return 0; }
}


// Works
List<? extends Comparable<?>> list1 = new ArrayList<>(Arrays.asList(new K(), new K2()));