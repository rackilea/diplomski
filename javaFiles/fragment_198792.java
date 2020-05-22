int guess;
ArrayList<Integer> randomNumber = new ArrayList<Integer>();

for (int i = 0; i < 4; i++) {
   randomNumber.add(random.nextInt(LIMIT));
}

for (int i = 0; i < 4; i++) {
   System.out.print("Enter your guess number from 0 to 9: ");
   guess = input.nextInt();
   for (int j = 0; j < randomNumber.size(); ++j) {
      if (randomNumber.get(j) == guess) {
         ++totalCount;
         randomNumber.remove(j);
         break;
      }
   }
}
input.close();