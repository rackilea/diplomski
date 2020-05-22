public static int compareFoo(Object a, Object b){
    if(!(a instanceof foo && b instanceof foo)){
        return Integer.compare(a.hashCode(), b.hashCode());
    }

    Foo firstArg = (Foo)a;
    Foo secondArg = (Foo)b;

    return firstArg.getStatus().compareTo(secondArg.getStatus());//implement a getter in the foo class.
}