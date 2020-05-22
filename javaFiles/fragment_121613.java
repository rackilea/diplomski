System.out.println("Thank you! The numbers selected were: ");
Set<Integer> numbers = new HashSet<>();
for(int i = 0; i < times; i++) {
  lotNum = 0;
  for(int j = 0; j < game; j++) {
    do {
      randNum = (new java.util.Random()).nextInt(10);
    } while (numbers.contains(randNum));
    numbers.add(randNum);
    lotNum = (lotNum * 10) + randNum;
    System.out.print(randNum);
    sum += randNum;
  }
  numbers.clear();
  System.out.println();
}