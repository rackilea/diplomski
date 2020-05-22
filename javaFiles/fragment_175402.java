Scanner stdin = new Scanner(System.in);
length = stdin.nextInt();
amountOfCycles = stdin.nextInt();

cells = new Cell[length];
for (int i = 0; i < length; i++)
  cells[i] = new Cell(i);

barrier = new CyclicBarrier(length, () -> {
  System.out.println(Arrays.toString(cells)); //code that will run every time when all thread reach the cyclic barrier
});