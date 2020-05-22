Pizza cheapestSpicy =
    pizzas.stream()
          .filter(p -> p.getIngredients().stream().anyMatch(Ingredient::isSpicy))
          .min(Comparator.comparingInt(
             p -> p.getIngredients().stream().mapToInt(Ingredient::getPrice).sum()
          )).orElse(null);