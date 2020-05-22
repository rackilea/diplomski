int[] arr = { 1, 2, 3, 5, 6, 7, 8, 9, 5, 4, 7, 8, 9, 3, 2, 1, 0, 3, 4, 8 };

Set<Integer> set = new LinkedHashSet<Integer>();
for (int i : arr) {
    set.add(i);
}

// new array if you need it
int[] newArray = new int[set.size()];
int index = 0;
for (int i : set) {
    System.out.print(i+" ");
    newArray[index++] = i;
}