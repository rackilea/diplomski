class Person {
   String name;
   String country;
   int age;
   String eyeColor;

   public Person(String name, String country, int age, String eyeColor) {
      this.name = name;
      this.country = country;
      this.age = age;
      this.eyeColor = eyeColor;
   }

   @Override
   public String toString() {
     return String.format("%s:%s:%d:%s", country, name, age, eyeColor);
   }
}