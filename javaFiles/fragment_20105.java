public class MyClass<T> {

   private Class<T> clazz;
   public MyClass (Class<T> clazz) {
     this.clazz = clazz;
   }

   public String getPackageNameOfGenericClass() {
     return clazz.getPackage().getName(); 
   }

}