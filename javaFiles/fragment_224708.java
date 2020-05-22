public interface Comparator<T> {
   public int Compare(T t1, T t2); 
}

public StringLengthsComparator implements Comparator<String> {
    public int.Compare(String s1, String s2) { return s1.length() - s2.length();}
}