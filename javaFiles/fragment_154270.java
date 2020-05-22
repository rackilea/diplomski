public static void main(String[] args) {
    // TODO Auto-generated method stub
    method1();
}
public static String method1()
{
    String rv = "";
    for(int i = 0; i <= 4; i++)
    {
        Random r = new Random();
        int number = r.nextInt((100) - 0) * 100;
        System.out.println("your number is " + number);
    }
    return rv;
}