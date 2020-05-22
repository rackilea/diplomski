public static int getRandomX(int max, int[] exclude){
    Set<Integer> set = Arrays.stream(exclude).boxed().collect(Collectors.toSet());
    if(set.size() == max){
        throw new IllegalArgumentException("All numbers in range [0 - " +(max-1)+"] excluded");
        //or return -1;
    }
    Random randomGenerator = new Random(max);
    Integer random = randomGenerator.nextInt(max);
    while(!set.add(random)){
        random = randomGenerator.nextInt(max);
    }
    return random;
}