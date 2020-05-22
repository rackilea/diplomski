public class Arrays {

        public static void main(String[] args) {
                Integer blankPosition = Integer.parseInt(args[0]);
                // Using 99 instead of "--" because of array type
                int[] table = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 99};
                printEm(table);
                for (int i = table.length - 1; i > blankPosition; i--) {
                        table[i] = table[i - 1];
                }
                table[blankPosition] = 99;
                printEm(table);
        }

        public static void printEm(int[] array) {
                for(int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                }
                System.out.println();
        }
}