import java.util.HashSet;
import java.util.Set;

public class Test {

   public static void main(String[] args) throws Exception {
      Set<Alpha> s = new HashSet<Alpha>();
      Alpha a1 = new Alpha();
      Alpha a2 = new Alpha();
      s.add(a1);
      s.add(a2);
      System.out.println(s.size());
   }
}

class Alpha {
   int a = 10;

   @Override
   public int hashCode() {
      return a;
   }

   public String toString() {
      return "Alpha : " + a;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Alpha other = (Alpha) obj;
      if (a != other.a)
         return false;
      return true;
   }
}