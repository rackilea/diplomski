List<Ingredient> main = new ArrayList<>();
List<Ingredient> other = new ArrayList<>();

//Sort on `admin` in descending order
Comparator<Ingredient> compartor = Comparator.comparing(Ingredient:: getAdmin, (i1, i2) -> {
    if (i2 > i1) {
        return -1;
    } else if (i2 < i1) {
        return 1;
    } 
    return 0;
});

//Go through each list (ingredient) and find the one with max `admin` value 
//and add it to the `main` list then add the rest to `other`
ingredientsByName.forEach( (k, group) -> {
    Ingredient max = group.stream().max(compartor).get();
    if (max.getAdmin() == 0) {
        max = group.get(0);
    }
    main.add(max);
    group.remove(max);
    other.addAll(group);
});