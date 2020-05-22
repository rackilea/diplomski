import java.util.Comparator; // <--- Import!

public class IntegerComparator 
      implements Comparator<Integer>{

   public IntegerComparator(){}

   public int compare(Integer a, Integer b){
      int aValue = a.intValue();
      int bValue = b.intValue();
      return (aValue - bValue);
   }
}