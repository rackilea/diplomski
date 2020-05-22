import java.util.function.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Supplier<String> supplier = () -> null;
        System.out.println(supplier.get());
    }
}