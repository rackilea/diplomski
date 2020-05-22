enum Player { MAX, MIN }

interface Node {
  boolean isTerminal();
  int utility();
  Player nextPlayer();
  List<Node> children();
}