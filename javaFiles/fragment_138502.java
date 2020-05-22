public static void permute(List<String> list, int left, int right) {
    if (left == right) {
        System.out.println(Arrays.toString(list.toArray()));
        return;
    }
    for (int j = left; j <= right; j++) {
        Collections.swap(list, left, j);
        permute(list, left + 1, right);
        Collections.swap(list, left, j);
    }
}

public static void showAllPermute(List<String> list) {
    int size = list.size();
    permute(list, 0, size - 1);
}