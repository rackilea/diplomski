final int DISTANCE = 15, MIN = 25, MAX = 726, COUNT = 8;

ThreadLocalRandom random = ThreadLocalRandom.current();
TreeSet<Integer> numbers = new TreeSet<>();
while (numbers.size() < COUNT) {
    int value = random.nextInt(MIN, MAX);
    Integer ceiling = numbers.ceiling(value - DISTANCE);
    if (ceiling == null || ceiling > value + DISTANCE)
        numbers.add(value);
}
System.out.println(numbers);