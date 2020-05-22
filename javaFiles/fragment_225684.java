public static List<Integer> primeFactorization(int a) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 2; i <= a ; i++) {
        while (a % i == 0) {
            list.add(i);
            a /= i;
        }
    }
    return list;
}