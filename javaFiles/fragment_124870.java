public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    while (set.size() < 10) set.add((int)(Math.random() * 31) + 1);
    Integer[] randArray = set.toArray(new Integer[0]);
    for (int i = 0; i < randArray.length; i++) {
        System.out.print(randArray[i] + " ");
    }
    System.out.println();
}