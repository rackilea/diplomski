public interface Person {
     public abstract String getName();
}

public class Employee implements Person {

     private String name;
     private int id;

     public void setName(String name){
         this.name = name;
     }

     public String getName(){
         return name;
     }
}