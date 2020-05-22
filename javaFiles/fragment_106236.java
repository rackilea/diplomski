class Untitled {
  private static abstract class Animal {
    public String getType() {
      return this.getClass().getSimpleName();
    }
  }

  private static class Bird extends Animal {

  }

  private static class Dog extends Animal {

  }

  public static void main(String[] args) {
    Animal bird = new Bird();
    System.out.println(bird.getType()); // prints Bird

    Animal dog = new Dog();
    System.out.println(dog.getType()); // prints Dog
  }
}