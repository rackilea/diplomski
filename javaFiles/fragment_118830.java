private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {

    return ingredients.stream()
            .filter(x -> x.getType().equals(type))
            .collect(Collectors.toList());

}