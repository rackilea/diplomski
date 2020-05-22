/**
 * @param args
 */
public static void main(String[] args) {
    method( getValue());
}

private static void method(@NonNull Object obj){
    System.out.println(obj);
}

@CheckForNull
private static Object getValue(){
    Map map = new HashMap();
    return map.get("foo");
}