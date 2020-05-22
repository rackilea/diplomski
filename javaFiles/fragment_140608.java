public interface Project {
    int getAmount();
}
public class Stuff {
    private Project p;
    public Stuff(Project aProject) {
        this.p = aProject;
    }
    public int getValue() {
        return p.getAmount();
    }
}