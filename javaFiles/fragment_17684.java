public class Course {
    private String name;
    private int rating;

    public Course(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rating; i++) {
            sb.append("+");
        }
        return String.format("%s: %s", name, sb);
    }
}