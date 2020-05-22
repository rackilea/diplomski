public class HelloDate {

    public static int Summation(int[][] myArray) {

        int sum = 0;

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                sum += myArray[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[][] myArray = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }, { 9, 10 }, { 11, 12 }, { 13, 14 },
                { 15, 16 }, { 17, 18 }, { 19, 20 } };

        int sum = HelloDate.Summation(myArray);

        System.out.println(sum);

    }
}