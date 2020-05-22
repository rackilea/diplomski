Animal[] arr = new Animal[6];

arr[0] = new Fish("Riby", "Sea Fish");
arr[1] = new Dog("Any", "Great Dane");
arr[2] = new Fish("Ribytsa", "River fish");
arr[3] = new Dog("Jackie", "Pug");
arr[4] = new Fish("Bobi", "Mix");
arr[5] = new Dog("Ruby", "Labrador");

for (Animal a : arr) {
   System.out.println(a.getName() + " " + a.getBreed());
   a.moving();
}