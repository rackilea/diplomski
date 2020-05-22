public class Delete
{
    public static void main(String[] args) throws Throwable
    {
        System.out.println("Running");

        System.out.println("Deleting");
        Runtime.getRuntime().exec("cmd /c ping localhost -n 6 > nul && del Delete.jar");

        System.out.println("Ending");
        System.exit(0);
    }
}