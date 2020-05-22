public class Course {

    private long id;
    private String title;

    public Course(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + '}';
    }

}