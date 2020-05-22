Ingredient a = new Ingredient();
a.setName("IngrA");
Ingredient b = new Ingredient();
b.setName("IngrB");
List<Ingredient> ingrs = new ArrayList<>(2);
ingrs.add(a);
ingrs.add(b);
s.setIngredients(ingrs);
repository.save(s); //Error will be thrown here; If you have CascadeType.All an insert will be done