Recipe recipe = new Recipe();
recipe.setId(1);
recipe.setName("name");

doThrow(Exception.class)
        .when(recipeService)
        .save(recipe);