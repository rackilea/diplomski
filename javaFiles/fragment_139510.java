public class MyKey implements Comparator<MyKey> {
    private String field;

    public boolean compare(MyKey m1, MyKey m2) {
        // We must ignore this.field!  We are comparing m1 and m2 ...
        return m1.field.compareTo(m2.field);
    }
}

MyKey[] keys = ...
Arrays.sort(keys, new MyKey());  // Note we have to pass an instance
                                 // to provide the Comparator.