public class User {
    private String name;
    private Long rep;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getRep() { return rep; }

    public void setRep(Long rep) { this.rep = rep; }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", rep=" + rep +
                '}';
    }
}