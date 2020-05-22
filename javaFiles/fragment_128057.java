public class RandomNumberGenerator {

    private int minimum;
    private int maximum;
    private Iterator<Integer> iter;

    public RandomNumberGenerator(int min, int max) {
        minimum = min;
        maximum = max;
        reset();
    }

    public void printRandomNumber() {

        System.out.println("The next random number is: " + iter.next());
    }

    public boolean shouldReset() {
        return !iter.hasNext();
    }

    public void reset() {
        List<Integer> list = new ArrayList<>(IntStream.rangeClosed(min, max).boxed().collect(Collectors.toList()));
        Collections.shuffle(list);
        iter = list.iterator();
    }
}