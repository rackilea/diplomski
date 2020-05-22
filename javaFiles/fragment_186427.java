ArrayList<RecipeDTO> recipes = new ArrayList<RecipeDTO>() {{

    add(new RecipeDTO(Arrays.asList("onion", "rice"), Arrays.asList("yummy", "spicy")));
    add(new RecipeDTO(Arrays.asList("garlic", "tomato"), Arrays.asList("juicy", "salty")));

}};

List<String> ingredientsAndKeywords = recipes.stream()
        .flatMap(recipe -> Stream.concat(recipe.getIngredients().stream(), recipe.getKeywords().stream()))
        .map(String::toLowerCase)
        .collect(toList());

for (String ingredientsAndKeyword : ingredientsAndKeywords) {
    System.out.println(ingredientsAndKeyword);
}