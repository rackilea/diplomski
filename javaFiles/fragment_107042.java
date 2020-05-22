public static void main(String[] args) {
    List<String> list = List.of("Seven", "Eight", "Nine");

    list.stream().filter(s -> s.length() >= 5)
                 .filter(s -> s.contains("n"))
                 .forEach(System.out::println);
}

public static void main(java.lang.String[]);
Code:
   0: ldc           #16                 // String Seven
   2: ldc           #18                 // String Eight
   4: ldc           #20                 // String Nine
   6: invokestatic  #22                 // InterfaceMethod java/util/List.of:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;
   9: astore_1
  10: aload_1
  11: invokeinterface #28,  1           // InterfaceMethod java/util/List.stream:()Ljava/util/stream/Stream;
  16: invokedynamic #35,  0             // InvokeDynamic #0:test:()Ljava/util/function/Predicate;
  21: invokeinterface #36,  2           // InterfaceMethod java/util/stream/Stream.filter:(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;
  26: invokedynamic #42,  0             // InvokeDynamic #1:test:()Ljava/util/function/Predicate;
  31: invokeinterface #36,  2           // InterfaceMethod java/util/stream/Stream.filter:(Ljava/util/function/Predicate;)Ljava/util/stream/Stream;
  36: getstatic     #43                 // Field java/lang/System.out:Ljava/io/PrintStream;
  39: invokedynamic #52,  0             // InvokeDynamic #2:accept:(Ljava/io/PrintStream;)Ljava/util/function/Consumer;
  44: invokeinterface #53,  2           // InterfaceMethod java/util/stream/Stream.forEach:(Ljava/util/function/Consumer;)V
  49: return