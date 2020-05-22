public static class ScalaLongWrapper implements Comparable<scala.Long>{
     public scala.Long v;

     public ScalaLongWrapper(scala.Long l){
         this.v = l;
     }

     public int compareTo(scala.Long l){
         return this.v - l;
     }
 }