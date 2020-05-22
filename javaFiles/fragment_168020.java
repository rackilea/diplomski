public class Student implements Comparable {
    private int grade;

    @Override
    public int compareTo(Object other) {
        if (other instanceof Student) {
            return Integer.compare(this.grade, ((Student) other).grade);
        }
        return -1;
    }
}