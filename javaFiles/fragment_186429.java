List<String> ingredientsAndKeywords = recipes.stream()
                .map(recipe -> Stream.concat(recipe.getIngredients().stream(), recipe.getKeywords().stream())
                        .map(String::toLowerCase).collect(joining(" ")))
                .collect(toList());

        for (String ingredientsAndKeyword : ingredientsAndKeywords) {
            System.out.println(ingredientsAndKeyword);
        }