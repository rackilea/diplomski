public class ArrayPredicate implements Predicate<Object[]> {    

    public boolean test(Object[] a) {
       if(a == null) return false;
       if(a.length == 0) return false;
       for(Object o: a) {
          if(o == null) return false;
       } 
       return true;
    }    
 }