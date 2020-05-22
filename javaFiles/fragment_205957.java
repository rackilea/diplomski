1  abstract class A {
 2    public abstract <T> T getId();
 3  }
 4  class B extend A {
 5    public Long getId() {
 6      return Long.valueOf(1);
 7     }
 8  }
 9  public class Main {
10    public static void main(String [] args) {
11      FastClass fast = FastClass.create(A.class); // changed, was FastClass.create(B.class)
12      FastMethod fastMethod = fast.getMethod("getId", null);
13      try {
14        final B b = new B();
15        Long value = (Long) fastMethod.invoke(b, null);
16      } catch (Exception e) {
17        e.printStackTrace();
18      }
19    }
20  }