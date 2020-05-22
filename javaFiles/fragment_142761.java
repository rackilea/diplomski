public class StackOverflow {
    public static void main(String args[]) {
        System.out.println(printMiles(new int[] { 10, 20, 30 }));
    }

    public static String printMiles(int[] allMiles) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < allMiles.length; i++) {
            sb.append(String.format("Index %d intput is %d\r\n", i + 1, allMiles[i]));
        }

        return sb.toString();
    }
}