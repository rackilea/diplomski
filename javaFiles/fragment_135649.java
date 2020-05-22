HashSet numbers = new HashSet();
Random rand = new Random();

while(numbers.size() < MAX_SIZE) {
    numbers.add(rand.nextInt(1000));
}