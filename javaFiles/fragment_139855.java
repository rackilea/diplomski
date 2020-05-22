public class Data implements Comparable<Data>{
    @Override
    public int compareTo(Data another) {
        return this.title.compareTo(another.title);
        // can also compareToIgnoreCase if not case sensitive
    }
}