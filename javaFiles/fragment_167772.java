List<Animal> animals = ...
for (Animal animal: animals) {
    Method method = animal.getClass().getMethod("oink");
    if (method != null)
        method.invoke(animal);
}