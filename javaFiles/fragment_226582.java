public class SingleTonBillPaugh
{
    public static SingleTonBillPaugh getInstance()
    {
        return SingleTonHelper.instance;
    }

    private SingleTonBillPaugh()
    {
        System.out.println(Thread.currentThread().getName() + " instance is going to be created");
    }

    static class SingleTonHelper
    {
        private static final SingleTonBillPaugh instance = new SingleTonBillPaugh();
    }
}