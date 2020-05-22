public ProjectTwoClass{

 public static String projectTwoMethod(String someThing) throws Exception {
   try{
      .....
   }catch(Exception e){
     throw e; // Rethrow the exception instead of creating a new one.
   }
 }
}