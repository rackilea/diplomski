public class Cat
 { 
     String name;
     String colour;
     int age;

     public static void main(String[]args)
     {    
        Cat c = new Cat();
        c.name = "Muffin";

        System.out.println(c.name);
     }

     void meow() 
     {
         System.out.println("Meow! Meow!");
     }
 }