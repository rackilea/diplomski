public static void main(String[] args) {
    Integer[] nums = {1,2,3,4,5};
    List<Integer> nums_lst = Arrays.asList(nums);
    LinkedList<Integer> lst = new LinkedList<Integer>(nums_lst);
    int result = Fold.fold(a -> b -> a + b, 0, lst);
    System.out.println(result);  // should be 15
    System.out.println(lst);  // should be [1,2,3,4,5]
}