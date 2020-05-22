Animal[] animals = {AnimalFactory.createAdapter(cat), AnimalFactory.createAdapter(dog)};

for (Animal animal : animals) {
    animal.speak();
    animal.eat();
}