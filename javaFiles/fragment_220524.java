public static void main(String[] Args) {
        String x = "Hello World ";
        char[] y = new char[x.length()];
        int i;
        int z = 0;
        int a = 1;
        while (a <= x.length()) {
            y[z] = x.charAt(x.length() - a);
            System.out.println(y[z]);
            z = z + 1;
            a = a + 1;
        }
    }