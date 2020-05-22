public void replaceIngredent(Ingredient oldIngredient, Ingredient newIngredient) {
    int index = ingredients.indexOf(oldIngredient);
    if (index != -1) {
        ingredients.remove(index);
        ingredients.add(index, newIngredient);
    }
}