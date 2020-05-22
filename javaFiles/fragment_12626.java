import java.util.*;
public class Main{
public static void main(String[] args){
  List<Integer> numbers = new ArrayList<Integer>(5);
  int max = 1000000;
  // Warmup
  for (int i=0;i<max;i++) {
    numbers.add(i);
  }

  long start = System.currentTimeMillis();
  numbers = new ArrayList<Integer>(max);
  for (int i=0;i<max;i++) {
    numbers.add(i);
  }
  System.out.println("Preall: "+(System.currentTimeMillis()-start));

  start = System.currentTimeMillis();
  numbers = new ArrayList<Integer>(5);
  for (int i=0;i<max;i++) {
    numbers.add(i);
  }
  System.out.println("Resizing: "+(System.currentTimeMillis()-start));

}
}