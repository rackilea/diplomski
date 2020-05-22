public static <T, U> U myMethod(Function<T, U> methodParam, T t) {
  return methodParam.apply(t);
}

public static void main(String[] args) {
   System.out.println(myMethod(Long::valueOf, "Today is happy day!") );
}