public class Restaurant
{
    String name;
    FoodCategory category;

    public Restaurant(String name, FoodCategory category)
    {
        this.name = name;
        this.category = category;
    }

    public String getName()
    {
        return name;
    }
}