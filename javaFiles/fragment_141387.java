public class Dog{

   private String dName;
   priavet int dAge;

   public Dog(String dName, String dAge){

      this.dName = dName;
      this.dAge = dAge;


   }



   public String getDName(){

        return this.dName;

   }

   public String getDName(){

        return this.dAge;

   }

}


public class Test{


 public static void main(String[] args){

     List<Dog> dAList = new ArrayList<Dog>();

     dAList.add(new Dog("Tommy",5));
     dAList.add(new Dog("Stark",2));

     for(Dog d : dAList){   // Iterating over the List of Dog objects

           System.out.println(d.getDName());
           System.out.println(d.getDAge());

         }


     }



}