public Food[] groupProtein() {
    for(Food food : foodList)
    {
        if(food.getProtein() > 6){
            proteinFoods.add(food);
        }
    }

    return proteinFoods.toArray(new Food[0]);
}