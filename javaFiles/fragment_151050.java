public static <T,U> String addValues(FirstGeneric<T> myGeneric, FirstGeneric<U> 
   myGeneric1) {
    String result = null;
    if (myGeneric != null && myGeneric1 != null) {
        T t1 = myGeneric.getValue();
        U t2 = myGeneric1.getValue();
        result = t1.toString().concat(t2.toString());
        System.out.println("Result is:=" + result);
    }
    return result;
}