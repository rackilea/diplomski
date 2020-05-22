List<Animal> animals = ...
for (Animal animal: animals) {
    Method method = animal.getClass().getDeclaredMethod("oink");
    if (method != null) {
        method.setAccessible(true);
        method.invoke(animal);
    }
}