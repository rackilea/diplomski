private static List<Integer> numbers=new ArrayList<>();
public synchronized void extend (int i) throws InterruptedException {
    synchronize(numbers) {
        numbers.add(i);
    }
}