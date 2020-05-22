Compiled from "ExampleMap.java"
public class ExampleMap<K, V> extends java.util.HashMap<K, V> {
  public ExampleMap();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/util/HashMap."<init>":()V
       4: return

  V getOrDefault1(java.lang.Object, V);
    Code:
       0: aload_0
       1: aload_1
       2: invokevirtual #2                  // Method get:(Ljava/lang/Object;)Ljava/lang/Object;
       5: dup
       6: astore_3
       7: ifnonnull     18
      10: aload_0
      11: aload_1
      12: invokevirtual #3                  // Method containsKey:(Ljava/lang/Object;)Z
      15: ifeq          22
      18: aload_3
      19: goto          23
      22: aload_2
      23: areturn

  V getOrDefault2(java.lang.Object, V);
    Code:
       0: aload_0
       1: aload_1
       2: invokevirtual #2                  // Method get:(Ljava/lang/Object;)Ljava/lang/Object;
       5: astore_3
       6: aload_3
       7: ifnonnull     18
      10: aload_0
      11: aload_1
      12: invokevirtual #3                  // Method containsKey:(Ljava/lang/Object;)Z
      15: ifeq          22
      18: aload_3
      19: goto          23
      22: aload_2
      23: areturn
}