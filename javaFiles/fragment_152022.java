class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        long a =  5; // "00101"
        long b = 20; // "10100"
        long c = 0;  // the result
        long pos = 1; // value of next position in result

        while (a > 0) {
            if ((a & 1) == 1) {
                c = c + (pos * (b & 1));
                pos = pos << 1;
            }
            a = a >> 1;
            b = b >> 1;
        }
        System.out.println("result=" + c);  //  2 ("10")
    }
}