public class Test005 {

    private static int[] temps = new int[] { 45, 76, 12, 102, 107, 65, 43, 67, 81, 14 };

    public static int NetChange() {
        int BiggestNet = Math.abs(temps[0] - temps[1]);
        for (int i = 0; i < temps.length - 1; i++) {
            if (Math.abs((temps[i] - temps[i + 1])) > BiggestNet) {
                BiggestNet = Math.abs(temps[i] - temps[i + 1]);
            }
        }
        return BiggestNet;
    }

    public static void main(String[] args) {

        System.out.println(NetChange());

    }
}