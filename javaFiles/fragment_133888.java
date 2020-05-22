@Override
public int compareTo(MyObject o) {
    return chainedCompare(this, o,
             Comparator.comparing(obj -> obj.name),
             Comparator.comparingInt(obj -> obj.index)
           );
}