public class MyClass{
   private MyClass relatedInstance;     
   //some members and methods

   public int getMyInt(){
     //return something
   }

   public MyClass getRelatedInstance(){
     return this.relatedInstance;
}

List<myClass> my_vector = getFilledList();
request.setAttribute("vectors name",my_vector)