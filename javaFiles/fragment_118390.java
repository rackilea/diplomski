final Map<String, Dish> dishMap = (Map<String, Dish>)application.getAttribute("allDishesHashMap");

for (final Map.Entry dishEntry: dishMap.entrySet())
{ 
  final Map <String, String> ingredientMap = dishEntry.getIngredients();

  out.println("<li><strong>" + dishEntry.getKey() + "</strong> Ingredients: <ul>");

  for (final String ingredientName : ingredientMap.keySet())
  {
    out.println("<li>" + ingredientName + "</li>")
  }

  out.println("</ul></li>");
}