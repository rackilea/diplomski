public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 8, -3, 5, -6, -12, 5, -12, -95, -32, 0, 3, 9);
    list = new ArrayList<>(list); //Make the list modifiable. Ignore this
    list.removeIf(i -> i <= 0); //Remove negatives and 0s
    Collections.sort(list);
    System.out.println(list);
    if (list.size() >= 3)
        System.out.println(list.get(2));
    else
        System.out.println("na");
}