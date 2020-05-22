public static void main(String... args) {
    List<Integer> list = new ArrayList<>();
    int[] arr = new int[]{1,0,5,4,7,8,6};
    for (int a : arr) {
        list.add(a);
    }
    System.out.println("After adding: " + list);
    System.out.println(list.indexOf(4));
    System.out.print("Popping out now: ");
    while(!list.isEmpty()) {
        System.out.print(list.remove(0) + " ");
    }
}