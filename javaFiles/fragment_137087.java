public static void main(String[] args) {
    List<Integer> list = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 });
    List<Integer> res =new ArrayList<>();
    fillBST(res, list, 0, list.size() - 1);
    System.out.println(res);
}

public static List<Integer> fillBST(List<Integer> b, List<Integer> nums, int start, int end) {
    int mid = (int)Math.round((1.0 * start + end) / 2);
    b.add(nums.get(mid));
    if (start <= mid - 1)
        fillBST(b, nums, start, mid - 1);
    if (end >= mid + 1)
        fillBST(b, nums, mid + 1, end);
    return b;
}