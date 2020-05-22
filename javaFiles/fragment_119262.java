public static void main(String[] args) {
    List<String> listOfString = List.of("sss"); // String extends from Object
    List<Integer> listOfInt = List.of(1); // Integer extends from Object
    List<Object> list = flat(listOfString, listOfInt);
    System.out.println(list); // [sss, 1]
}