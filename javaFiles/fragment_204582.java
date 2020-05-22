String str =
    pizzas.stream()
          .map(p -> p.getName() + ": " + 
                     p.getIngredients().stream()
                                       .map(Ingredient::getPreetyName)
                                       .collect(Collectors.joining(", "))
          )
          .collect(Collectors.joining(System.lineSeparator()));