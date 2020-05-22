import java.util.HashSet;
public class ProjectEulerOne{
 public static void main(String[] args){
 HashSet<Integer> SetA= new HashSet<Integer>();
  for(int i = 3; i<1000; i+=3){
     SetA.add(new Integer(i));
  }
  for(int i = 3; i<1000; i+=3){
     SetA.add(new Integer(i));
  }
  int total =0;
  Iterator<Integer> iter = numSet.iterator();
  Integer current;
  while(iter.hasnext()){
   current = iter.next();
   total += current.intValue();
  }
 }
}