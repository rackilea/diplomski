public ShapedRecipie lvl1ArmorHeadRecipie(){
  ShapedRecipe recipe = new ShapedRecipe(lvl2Head);
  recipe.shape("AAA", "ABA", "AAA");
  recipe.setIngredient('A', Material.DIAMOND);
  recipe.setIngredient('B', Material.LEATHER_HELMET);
  return recipie;
}

public void lvl1ArmorHead(){
  this.getServer().addRecipe(lvl1ArmorHeadRecipie());
  //do everything in here normally
}