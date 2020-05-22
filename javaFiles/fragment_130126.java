class Dog {
 private int age; //storage for the age value within the instance
 public Dog(int dogsAge){
   this.age = dogsAge; // set the value
 }
 // provide a way to access the age
 public int getAge() {
   return this.age;
 }
 public void bark(){
   System.out.println("Woof!");

 }
 public void run(int feet) {
   System.out.println("Your dog ran " + feet + " feet!");
 }


 public static void main(String[] args) {
  Dog spike = new Dog(3);
  spike.bark();
  spike.run(spike.getAge()); // retrieve the age and use it
 }

}