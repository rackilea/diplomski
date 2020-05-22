Random rgen = new Random();
for (int i = amounts.length - 1; i > 0; --i) {
   int randomPosition = rgen.nextInt(i + 1);
   double temp = amounts[i];
   amounts[i] = amounts[randomPosition];
   amounts[randomPosition] = temp;
}