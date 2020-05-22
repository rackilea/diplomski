public class Main {

    static int find(double T[], int left, int right, double numToSearch) {
        if (left <= right) {
            int middle = (left + right) / 2;
            if (T[middle] == numToSearch) {
                return middle;
            }
            if (T[middle] < numToSearch) {
                return find(T, middle + 1, right, numToSearch);
            }
            return find(T, left, middle - 1, numToSearch);
        }
        return -1;
    }

    public static void main(String[] args) {
        // create an array that you can use for searching a number, here it is 34 at index 8
        double[] array = {1, 2, 3, 4, 5, 6, 7, 30, 34, 44, 45, 66, 67, 71, 72, 73, 77, 85, 89, 90, 99};
        // use the find-method with a valid maximum index (right) and the array defined before
        System.out.println(find(array, 0, array.length - 1, 34));
    }

}