@TestAnno
public class Test {
  public static void main(String[] args) {
    Annotation[] annos = Test.class.getAnnotations();
    for (Annotation a : annos) {
      System.out.println(a);
    }
  }
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestAnno {
}