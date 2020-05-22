public static int reachNFloorSet (Set<Integer> numbers, int n) {
    if (n == 0) {
        return 1;
    }

    int sum = 0;
    for(Integer x: numbers) {

        if (x <= n) {

            sum += reachNFloorSet(numbers, n-x);

        }
    }
    return sum;
}