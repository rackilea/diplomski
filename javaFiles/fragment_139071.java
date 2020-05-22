private static <T extends Number> void processList(List<T> someList) {
    T n = someList.get(0);
    someList.add(1,n); //addition allowed.   
}

private static void processList2(List<? extends Number> someList) {
    Number n = someList.get(0);
    //someList.add(1,n);//Compilation error. Addition not allowed.
    processList(someList);//Helper method for capturing the wildcard
}