Compiled from "ObjectArray.java"
class lines.ObjectArray<T> {
  final java.lang.Object[] underlying;

  lines.ObjectArray(int);
    Code:
       0: aload_0
       1: invokespecial #10                 // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iload_1
       6: anewarray     #3                  // class java/lang/Object
       9: putfield      #13                 // Field underlying:[Ljava/lang/Object;
      12: return

  T get(int);
    Code:
       0: aload_0
       1: getfield      #13                 // Field underlying:[Ljava/lang/Object;
       4: iload_1
       5: aaload
       6: areturn
}


Compiled from "GenericArray.java"
class lines.GenericArray<T> {
  final T[] underlying;

  lines.GenericArray(java.lang.Class<T>, int);
    Code:
       0: aload_0
       1: invokespecial #13                 // Method java/lang/Object."<init>":()V
       4: aload_0
       5: aload_1
       6: iload_2
       7: invokestatic  #16                 // Method java/lang/reflect/Array.newInstance:(Ljava/lang/Class;I)Ljava/lang/Object;
      10: checkcast     #22                 // class "[Ljava/lang/Object;"
      13: putfield      #23                 // Field underlying:[Ljava/lang/Object;
      16: return

  T get(int);
    Code:
       0: aload_0
       1: getfield      #23                 // Field underlying:[Ljava/lang/Object;
       4: iload_1
       5: aaload
       6: areturn
}