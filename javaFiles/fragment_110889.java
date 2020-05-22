int[] numbers = new int[] { 1,2,3,4,5,6,7,8,9,10 };
List<Integer> resultList = new ArrayList<>();
for (int number: numbers) {
    int sqrRoot = (int) Math.round(Math.sqrt(number));
    if (sqrRoot * sqrRoot == number) {
        resultList.add(number);
    }
}