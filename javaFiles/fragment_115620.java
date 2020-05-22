class WriteOut {
    public static int sumas; // To allow System.out.println() to see this variable
    public void sud(int sds) {  
        sumas = sds;
    }

    public static void main(String arg[]) {
        WriteOut sum =new WriteOut();
        sum.sud(5);
        System.out.println("suma: "+sum.sumas);
    }
}