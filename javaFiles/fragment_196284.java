public final class Main
{
    private static void callIt(final Kapow theCallback)
    {
        theCallback.callbackMethod();
    }

    public static void main(String[] args)
    {
        Kapow kapowObject = new KapowImpl();

        callIt(kapowObject);
    }
}