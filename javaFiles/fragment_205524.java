public static void wildCardVarArgs(ThreadLocal<? extends Shape>... list) {
    for (ThreadLocal<? extends Shape> s : list) {
        Shape o = s.get(); //Compiler knows there's "at least" Shape inside
        System.out.println(o.someCustomMethod()); //And all Shapes have "someCustomMethod", does not matter if it is overriden or not
    }
}