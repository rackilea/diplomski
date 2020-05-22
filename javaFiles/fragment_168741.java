class Collator<S extends Stream<E>,E extends Comparable<E>> {
    S s;
    E e;

    public Collator(List<S> streams){
        s = streams.get(0);
        e = s.read();
    }

    public E next(){
        return e;
    }
}

interface Stream<E extends Comparable<E>>{
    public E read();
}

class Record implements Comparable<Record>{
    public Integer time;

    public int compareTo(Record r){
        return this.time.compareTo(r.time);
    }
}