public void updateRecipe(String id, List<IngredientDTO> newIngredients) {
  List<IngredientJDO> ingredients = convertIngredientDtosToJdos(newIngredients);
  PersistenceManager pm = PMF.get().getPersistenceManager();
  try {
    RecipeJDO recipe = pm.getObjectById(RecipeJDO.class, id);
    recipe.setIngredients(ingredients);
  } finally {
    pm.close();
  }
}