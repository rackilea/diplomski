public class Restaurants {

    private String name;

    public Restaurants(){}

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Restaurants" + "name" + name;
    }
}