public static void main(String[] args) {
    Vector<Integer> numbers = new Vector<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,6}));
    for (Integer integer : numbers) {
        System.out.println(integer);
        numbers.remove(2);
    }
}