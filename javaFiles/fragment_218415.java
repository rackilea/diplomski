public class Player {

    private String name;

    public void setName(String pName) {
        name = pName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "'}";
    }
}