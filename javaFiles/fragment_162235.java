public class GSonFieldMapping
{
    public static void main(String[] args)
    {
        String s = "{\"Sugar, Total\": 100, \"Vitamin-A\": 50}";

        Gson gson = new Gson();

        Food food = gson.fromJson(s, Food.class);

        System.out.println(food);
    }

}

class Food
{
    @SerializedName(value = "Sugar, Total")
    private int sugarTotal;
    @SerializedName(value = "Vitamin-A")
    private int vitaminA;
    @Override
    public String toString()
    {
        return "Food [sugarTotal=" + sugarTotal + ", vitaminA=" + vitaminA + "]";
    }

    // Getters and Setters
}