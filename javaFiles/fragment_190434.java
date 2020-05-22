public class gui extends JFrame implements ActionListener
{
  static final int WINS = 0, LOSSES = 1, DRAWS = 2;
  int[] counts = new int[3];
  String[] strings = {" You Win |", " You Lose |", " Tie |"};
  // this MUST be set up in the constructor, not here!
  JLabel[] labels = {JNumWin, JNumLose, JNumTie};
  ...