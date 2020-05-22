public static class Main {

    public static void main() {
        printAll("",3);
    }

    static void printAll(String prefix, int n) {
        if( n==0 ) {
            System.out.println(prefix);
        } else {
            for(char c='A'; c<= 'Z'; c++) {
                printAll(prefix+c, n-1);
            }
        }
    }
}