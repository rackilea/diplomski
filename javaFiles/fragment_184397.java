Drink d = drinksArrayList.get(position);
holder.ingredient0.setText(d.getName()));
StringBuilder ingredients = new StringBuilder();
for (Map.Entry<String, Integer> ingredient : d.getIngredients().entrySet()) {
    ingredients.append(" ");
    ingredients.append(ingredient.getKey());
    ingredients.append(", ");
    ingredients.append(Integer.toString(ingredient.getValue()));
    ingredients.append("\n");
}
holder.ingredient1.setText(ingredients.toString().trim());