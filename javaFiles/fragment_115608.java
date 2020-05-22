public class ClassA {
   ...
   public void removeAll(List<ClassC> objectsToRemove) {
       for(ClassB classB: classBList){
           classB.getClassCList().removeAll(objectsToRemove);
       }
   }
}