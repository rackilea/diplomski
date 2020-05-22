aspect A {
pointcut printMessage() : execution(* add(..));
 after() returning (int m): printMessage() {
            System.out.println(m);
}
}