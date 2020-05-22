public static void main(String[] args){
    Test t = new Test();
    Class<? extends Test> testClass = t.getClass();
    List<? extends Test> list = createListOfType(testClass);
}

private static <T> List<T> createListOfType(Class<T> type){
    return new ArrayList<T>();
}