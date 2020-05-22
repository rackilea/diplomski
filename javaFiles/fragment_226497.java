public class Test {

  public static boolean contains(final int[][]m, final int value) {
    int candidateRow = m.length;
    for (int row = 1; row < m.length; ++row) {
      if (m[row][0] == value) {
        return true;
      }
      if (m[row][0] > value) {
        candidateRow = row;
        break;
      }
    }

    for (int val : m[candidateRow - 1]) {
      if (val == value) {
        return true;
      }
    }

    if (candidateRow < m.length) {
      for (int val : m[candidateRow]) {
        if (val == value) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int [][] testArray = new int [][]{
        {   0,   2,   1,   2,   0,   5,   5,   5 },
        {  21,  21,   7,   7,   7,  21,  21,  21 },
        {  21,  21,  21,  21,  21,  21,  21,  21 },
        {  21,  21,  23,  42,  41,  23,  21,  21 },
        {  60,  56,  57,  58,  53,  52,  47,  51 },
        {  61,  65,  70,  72,  73,  78,  82,  98 },
        { 112, 121, 112, 134, 123, 100,  98, 111 },
        { 136, 136, 136, 134, 147, 150, 154, 134 }
    };
    for (int[] row : testArray) {
      for (int val : row) {
        System.out.print(contains(testArray, val) + " ");
      }
      System.out.println();

    }
    System.out.println();
    System.out.println();
    final int[] notInMatrix = { -1, 3, 4, 6, 8, 22, 30, 59, 71, 113, 135 };
    for (int val : notInMatrix) {
      System.out.print(contains(testArray, val) + " ");
    }
    System.out.println();
  }
}