Ingredient a = ingredientDao.findByName("IngrA");
Ingredient b = ingredientDao.findByName("IngrB");
List<Ingredient> ingrs = new ArrayList<>(2);
if(a!=null)
   ingrs.add(a);
if(b!=null)
   ingrs.add(b);
s.setIngredients(ingrs);
repository.save(s); //No error will be thrown here