public class Child(){
       public static int age = 1;

       public Child(){
       }
    }

    public class School(){
       int var_age;

       public School(){
          var_age = Child.age;
       }
    }