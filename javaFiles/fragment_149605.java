public class Event extends Model implements Comparable{

...


    @Override
    public int compareTo(MyObject o) {
        return getDateTime().compareTo(o.getDateTime());
    }
}