public class MyPosition implements Comparable<MyPosition>{
    private Integer priority;

    @Override
    public int compareTo(MyPosition that) {
        return this.priority.compareTo(that.priority);
    }
}