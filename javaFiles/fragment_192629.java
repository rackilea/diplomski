public class Cumpare implements Comparator<List<String>> {

private final int[] indexes;

public Cumpare(final int[] indexes) {
    this.indexes = indexes;
}


@Override
public int compare(final List<String> o1, final List<String> o2) {
    int value = 0;
    for(int i : indexes){
        value = o1.get(i).compareTo(o2.get(i));
        if (value!=0) break;                        
    }
    return value;
}
}