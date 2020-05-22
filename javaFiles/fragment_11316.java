// ...
public void addFavoriteFood(Food food) {
    favoriteFoods.add(food.getKey());
    food.getFoodFans().add(getKey());
}

public void removeFavoriteFood(Food food) {
    favoriteFoods.remove(food.getKey());
    food.getFoodFans().remove(getKey());
}