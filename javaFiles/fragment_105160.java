/**
 * Class implementing hashCode/equals based on ingred and unit
 * for use as key in a HashMap
 */
private static class IngredientWrapper {
    private final Ingredients ingredient;

    private IngredientWrapper(Ingredients ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient.getIngred(), ingredient.getUnit());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        IngredientWrapper other = (IngredientWrapper) obj;
        return Objects.equals(ingredient.getIngred(), other.ingredient.getIngred())
                && Objects.equals(ingredient.getUnit(), other.ingredient.getUnit());
    }

}

private static ObservableList<Ingredients> mergeList(ObservableList<Ingredients> all) {
    ObservableList<Ingredients> newList = FXCollections.observableArrayList();
    Map<IngredientWrapper, Integer> indices = new HashMap<>();
    Integer index = 0;

    for(Ingredients ingredient : all) {
        Integer listIndex = indices.putIfAbsent(new IngredientWrapper(ingredient), index);
        if (listIndex == null) {
            // combination not yet in the list
            newList.add(ingredient);
            index++;
        } else {
            // combination already in the list
            Ingredients listIngredient = newList.get(listIndex);
            listIngredient.setAmount(listIngredient.getAmount() + ingredient.getAmount());
        }

    }
    return newList;
}