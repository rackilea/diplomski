public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("text1");
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(1000);
        }
        System.out.println();
        System.out.println("text2");
    }
}