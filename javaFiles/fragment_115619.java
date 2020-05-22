class WriteOut {
    private static int sumas;
    @Override
    public String toString(){
        return String.valueOf(sumas); // returns a string with sumas value
    }

    public static void main(String arg[]) {
        WriteOut sum =new WriteOut();
        sum.sud(5);
        System.out.println("suma: "+sum);
    }
}