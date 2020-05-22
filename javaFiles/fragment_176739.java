public class HelloWorld {
    static int[] array = {3, 6, 7, 3, 2, 30, 9, 13, 12, 1, 2, 1};
    static String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) {
        int index = 0;
        for (int i = 1; i < array.length; i++)
            if (array[index] < array[i])
                index = i;
        System.out.println(array[index] + " greatest month is: " + month[index]);
    }
}