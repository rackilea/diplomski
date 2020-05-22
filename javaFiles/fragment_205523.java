....
public static void wildCardVarArgs(ThreadLocal... list) {
    for (ThreadLocal s : list) {
        Object o = s.get(); //Compiler knows there's "at least" Object inside
        System.out.println(o.toString()); //And all Objects have "toString"
    }
}
....