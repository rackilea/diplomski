import java.util.*;

class Randoms {
  public static void main(String[] args) {
    List<Integer> randoms = new ArrayList<Integer>();
    Random randomizer = new Random();
    for(int i = 0; i < 8; ) {
      int r = randomizer.nextInt(8) + 1;
      if(!randoms.contains(r)) {
        randoms.add(r);
        ++i;
      }
    }
    List<Integer> clonedList = new ArrayList<Integer>();
    clonedList.addAll(randoms);
    Collections.shuffle(clonedList);

    int[][] cards = new int[8][];
    for(int i = 0; i < 8; ++i) {
      cards[i] = new int[]{ randoms.get(i), clonedList.get(i) };
    }

    for(int i = 0; i < 8; ++i) {
      System.out.println(cards[i][0] + " " + cards[i][1]);
    }
  }
}