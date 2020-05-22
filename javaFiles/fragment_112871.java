public static void main(String[] args){
    Test t = new Test();
    List<? extends Test> list = createListOfType(t);
}

private static <T> List<T> createListOfType(T element){
    return new ArrayList<T>();
}