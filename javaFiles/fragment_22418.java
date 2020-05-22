public class Domino3xN {
   static int count = 0;

   public static void main(String[] args) {
      addRow1(8, "", "", "");
      System.out.println(count);
   }

   static void addRow1(int N, String row1, String row2, String row3) {
      if (row1.length() == N && row2.length() == N && row3.length() == N) {
         count++; // found one!
         System.out.format("%s%n%s%n%s%n%n", row1, row2, row3);
         return;
      }
      if (row1.length() > row2.length()) { // not my turn!
         addRow2(N, row1, row2, row3);
         return;
      }
      if (row1.length() < N - 1)
         addRow2(N, row1 + "<>",
                    row2,
                    row3);
      if (row2.length() == row1.length())
         addRow3(N, row1 + "A",
                    row2 + "V",
                    row3);
   }
   static void addRow2(int N, String row1, String row2, String row3) {
      if (row2.length() > row3.length()) { // not my turn!
         addRow3(N, row1, row2, row3);
         return;
      }
      if (row2.length() < N - 1)
         addRow3(N, row1,
                    row2 + "<>",
                    row3);
      if (row3.length() == row2.length())
         addRow1(N, row1,
                    row2 + "A",
                    row3 + "V");
   }
   static void addRow3(int N, String row1, String row2, String row3) {
      if (row3.length() == row2.length()) { // not my turn!
         addRow1(N, row1, row2, row3);
         return;
      }
      if (row3.length() < N - 1)
         addRow1(N, row1,
                    row2,
                    row3 + "<>");
   }
}