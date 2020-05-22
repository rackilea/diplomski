Compiled from "GenericsExample.java"
public class GenericsExample<T> {
  private T member;

  public GenericsExample();
    Code:
       0: aload_0       
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return        

  public T foo(T);
    Code:
       0: aload_0       
       1: getfield      #2                  // Field member:Ljava/lang/Object;
       4: areturn       
}