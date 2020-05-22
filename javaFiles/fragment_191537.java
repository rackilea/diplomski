public class Bean implements Comparable<Bean> {
    private String name;
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean [name=" + name + ", lastName=" + lastName + "]";
    }

    @Override
    public int compareTo(Bean o) {
        return this.getName().compareTo(o.getName());
    }
}