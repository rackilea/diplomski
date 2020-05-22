public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 6, 0, 4556);

    System.out.println(inRange(list, 0, 10));
}

private static boolean inRange(List<Integer> list, int min, int max) {
    return list.stream().allMatch(i -> i >= min && i <= max);
}

>> false