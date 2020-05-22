public static void wildCardVarArgs(ThreadLocal... list) {
    for (ThreadLocal s : list) {
        Object o = s.get();
        Shape p = (Shape)o; //Java hopes this won't fail, because compiler checked that it should not
        System.out.println(p.someCustomMethod());
    }
}