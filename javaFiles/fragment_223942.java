Compiled from "VarScopes.java"
public class VarScopes {
  public static void forEachLoop(java.util.Collection<?>);
    Code:
       0: aload_0
       1: invokeinterface #1,  1            // InterfaceMethod java/util/Collection.iterator:()Ljava/util/Iterator;
       6: astore_1
       7: aload_1
       8: invokeinterface #2,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
      13: ifeq          33
      16: aload_1
      17: invokeinterface #3,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
      22: astore_2
      23: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
      26: aload_2
      27: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      30: goto          7
      33: return

  public static void iteratorLoop(java.util.Collection<?>);
    Code:
       0: aload_0
       1: invokeinterface #1,  1            // InterfaceMethod java/util/Collection.iterator:()Ljava/util/Iterator;
       6: astore_1
       7: aload_1
       8: invokeinterface #2,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
      13: ifeq          33
      16: aload_1
      17: invokeinterface #3,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
      22: astore_2
      23: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
      26: aload_2
      27: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      30: goto          7
      33: return

  public static void iteratorLoopExtendedScope(java.util.Collection<?>);
    Code:
       0: aload_0
       1: invokeinterface #1,  1            // InterfaceMethod java/util/Collection.iterator:()Ljava/util/Iterator;
       6: astore_1
       7: aload_1
       8: invokeinterface #2,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
      13: ifeq          33
      16: aload_1
      17: invokeinterface #3,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
      22: astore_2
      23: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
      26: aload_2
      27: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      30: goto          7
      33: return
…