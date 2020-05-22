public class Bean implements Comparable<Bean> {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "bean [Name=" + Name + "]";
    }

    @Override
    public int compareTo(Bean o) {
        return o.getName().compareTo(this.getName());
    }
}