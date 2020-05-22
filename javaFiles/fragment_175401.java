Scanner stdin = new Scanner(System.in);
length = stdin.nextInt();
amountOfCycles = stdin.nextInt();
barrier = new CyclicBarrier(length);
cells = new Cell[length];
for(int i=0; i<length; i++)
  cells[i] = new Cell(i);