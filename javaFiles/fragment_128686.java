public class Food {
    String foodName,foodDescription;
    int foodImageId;

    Food(String name,String description,int id)
    {
        this.foodName=name;
        this.foodDescription=description;
        foodImageId=id;
    }
    String getFoodName()
    {
        return foodName;
    }
    String getFoodDescription()
    {
        return foodDescription;
    }
    int getFoodImageId()
    {
        return foodImageId;
    }
    public String toString()
    {
        return foodName;
    }

}