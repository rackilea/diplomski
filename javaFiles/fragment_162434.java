class SizeTest {

    /**
     * For each primitive type int, short, byte and long,
     * attempt to make an array as large as you can until
     * running out of memory. Start with an array of 10000,
     * and increase capacity by 1% until it throws an error.
     * Catch the error and print the size.
     */    
    public static void main(String[] args) {
        int len = 10000;
        final double inc = 1.01;
        try {
            while(true) {
                len = (int)(len * inc);
                int[] arr = new int[len];
            }
        } catch(Throwable t) {
            System.out.println("int: " + len);
        }

        len = 10000;
        try {
            while(true) {
                len = (int)(len * inc);
                short[] arr = new short[len];
            }
        } catch(Throwable t) {
            System.out.println("short: " + len);
        }


        len = 10000;
        try {
            while(true) {
                len = (int)(len * inc);
                byte[] arr = new byte[len];
            }
        } catch(Throwable t) {
            System.out.println("byte: " + len);
        }

        len = 10000;
        try {
            while(true) {
                len = (int)(len * inc);
                long[] arr = new long[len];
            }
        } catch(Throwable t) {
            System.out.println("long: " + len);
        }
    }
}