public static <E, I extends Iterable<E>> void print(I iterable) {

    ArrayList<String> stringList = new ArrayList<>();
    for(E element: iterable) {
        stringList.add(element.toString());
    }
    String result = String.join(",", stringList);
    System.out.println(result);
}