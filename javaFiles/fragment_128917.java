public static void test_2(String path, int sum, int n) {
    if (sum == n) {
        System.out.println(path);
    } else if (sum < n) { // <-- only recurse if the sum is less than the target
        test_2(path+"1 ", sum + 1, n);
        test_2(path+"2 ", sum + 2, n);
        test_2(path+"3 ", sum + 3, n);
        test_2(path+"4 ", sum + 4, n);
    }
}