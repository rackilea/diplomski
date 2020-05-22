public static void main(String[] args) {
    System.out.println("BEFORE SORTING");
    printList(elements);

    Collections.sort(elements, new MyComparator<String>());

    System.out.println("\nAFTER SORTING");
    printList(elements);
}

private static void printList(List<String> list) {
    for (String s : list) {
        System.out.println(s);
    }

}