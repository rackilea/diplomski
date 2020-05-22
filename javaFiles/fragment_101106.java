public static int getRandomX(int max, int[] exclude){
    Set<Integer> set = Arrays.stream(exclude).boxed().collect(Collectors.toSet());
    Random randomGenerator = new Random(max);
    Integer random = randomGenerator.nextInt(max);
    while(!set.add(random)){
        random = randomGenerator.nextInt(max);
    }
    return random;
}