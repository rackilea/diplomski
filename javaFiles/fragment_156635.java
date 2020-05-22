public class BoxPriorityQueue extends PriorityQueue<Box> {
    @Override
    public boolean contains(Object obj) {
        if (!(obj instanceof Box)) {
            return false;
        }
        Box box = (Box) obj;
        return box.getAttribute();
    }
}