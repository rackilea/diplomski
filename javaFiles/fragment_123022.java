public abstract class Animal {
   public addToCount(Map<String,Integer> counters){
     // gets the class name of the child that has been called *new* on...
     String myClassName =  getClass().getName(); 
     Integer oldCount = conters.getOrDefault(myClassName, Integer.ZERO);
     conters.put(myClassName,oldCount.add(Integer.ONE));
   }
}