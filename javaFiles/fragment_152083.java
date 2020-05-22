ObjectList objList = new ObjectList();
for (int i=0; i<3; i++)  {
  Cat cat = new Cat("meow",i);
  Dog dog = new Dog("woof",i);
  objList.addCat(cat);
  objList.addDog(dog);
}