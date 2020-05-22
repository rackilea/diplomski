public E[] test(E a){
  E[] b = (E[])new Object[1];
  b[0] = a;
  System.out.println(b[0]);
  return b;
}

public static void main(String[] args){
    ArrTest<String> t = new ArrTest<String>();
    String[] result = t.test("Hello World");
}