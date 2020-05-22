public class ChuckNorrisException
    extends RuntimeException // <- Comment out this line on second compilation
{
    public ChuckNorrisException() { }
}

public class TestVillain {
    public static void main(String[] args) {
        try {
            throw new ChuckNorrisException();
        }
        catch(Throwable t) {
            System.out.println("Gotcha!");
        }
        finally {
            System.out.println("The end.");
        }
    }
}