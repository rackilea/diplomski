Random rand = new Random();
int lengthOfArray = 10;
final int MAX = 8;
int[] myArray = IntStream.generate(() -> rand.nextInt(MAX)) //
        .limit(lengthOfArray).toArray();
System.out.println(IntStream.of(myArray).mapToObj(String::valueOf) //
        .collect(Collectors.joining(" ")));