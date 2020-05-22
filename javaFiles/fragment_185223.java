public class Count {

    private static int count = 0;

    // resets the value to 0
    public static void reset() {
        count = 0;
    }

    // updates the value
    public static String update() {
        count++;
        if(count == 1000) count = 1;
        return String.format("%03d", count);
    }

    // main() is used for testing
    public static void main(String[] a) {

        for(int i=0; i< 1001; i++){
            String c1 = update();
            System.out.println(c1);
        }

        reset();

        String c2 = update();
        System.out.println(c2);

        String c3 = update();
        System.out.println(c3);


    }
}