Compiled from "GenericDeclarationTest.java"
class GenericDeclarationTest extends java.lang.Object{
GenericDeclarationTest();
  Code:
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   new     #2; //class java/util/ArrayList
   3:   dup
   4:   invokespecial   #3; //Method java/util/ArrayList."<init>":()V
   7:   astore_1
   8:   aload_1
   9:   ldc     #4; //String
   11:  invokeinterface #5,  2; //InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
   16:  pop
   17:  aload_1
   18:  iconst_0
   19:  invokeinterface #6,  2; //InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
   24:  checkcast       #7; //class java/lang/String
   27:  astore_2
   28:  new     #2; //class java/util/ArrayList
   31:  dup
   32:  invokespecial   #3; //Method java/util/ArrayList."<init>":()V
   35:  astore_3
   36:  aload_3
   37:  ldc     #4; //String
   39:  invokeinterface #5,  2; //InterfaceMethod java/util/List.add:(Ljava/lang/Object;)Z
   44:  pop
   45:  aload_3
   46:  iconst_0
   47:  invokeinterface #6,  2; //InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
   52:  checkcast       #7; //class java/lang/String
   55:  astore  4
   57:  return

}