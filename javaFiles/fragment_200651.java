GameOfLife gol = null;
final int one = 1, two = 2, three = 3, four = 4, five = 5;
switch (test) {
case one:
    gol = new GameOfLife("Input/life1.txt");
    break;
case two:
    gol = new GameOfLife("Input/life2.txt");
    break;
case three:
    gol = new GameOfLife("Input/life3.txt");
    break;
case four:
    gol = new GameOfLife("Input/life4.txt");
    break;
case five:
    gol = new GameOfLife("Input/life5.txt");
    break;
}
if (gol != null) {
  gol.print();
} else {
  System.err.println("error: no such GameOfLife " + test);
}