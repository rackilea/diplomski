public class Test { //Capitalized name for classes are used in Java
   private final ini[] locations; //key final mean that, is must be assigned before object is constructed and can not be changed later. 

   public Test(int[] locations) {
      this.locations = locations;//To access to class member, when method argument has the same name use `this` key word. 
   }

   public boolean ckeckYourSelf(int value) { //This method is accessed only from a object.
      for(int location : locations) {
         if(location == value) {
            return true; //When you use key word return insied of loop you exit from it. In this case you exit also from whole method.
         }
      }
      return false; //Method should be simple and perform one task. So you can ge more flexibility. 
   }
   public static int[] locations = {1,2,3};//This is static array that is not part of object, but can be used in it. 

   public static void main(String[] args) { //This is declaration of public method that is not part of create object. It can be accessed from every place.
      Test test = new Test(Test.locations); //We declare variable test, and create new instance (obect) of class Test.  
      String result;
      if(test.checkYourSelf(2)) {//We moved outsie the string
        result = "Hurray";        
      } else {
        result = "Try agian"
      }
      System.out.println(result); //We have only one place where write is done. Easy to change in future.
   } 
}