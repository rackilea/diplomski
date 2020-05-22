pulic class test {
    public static void main(String args[]) {
        System.out.print(foo(4));
    }

    public static String foo(int n) {
        String s = "";

        if(n == 0) {    //do nothing      
        }
        else {
            s = foo(n-1);
            System.out.print(s);
            s=s+n;
        }      
        return s;
    }
}