int max = 20;
System.out.println("Generating random integers in range 0.." + max);
Set<Integer> set = new HashSet<Integer>(max);
Random randomGenerator = new Random();
while (set.size() <= max) {
  int randomInt = randomGenerator.nextInt(max+1);
  System.out.println("Generated : " + randomInt);
  if (!set.add(randomInt))
      System.out.println("Set already has: " + randomInt);
}
System.out.println("Set has: " + set);