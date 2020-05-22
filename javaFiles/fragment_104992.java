public class A
{
    private String [] values;

    public static void main(String [] args)
    {
        A test = new A(args);
        String [] values = test.getValues();  // Do whatever you want with them from here
    }

    public A(String [] values)
    {
        this.values = createDuplicate(values);
    }

    public String [] getValues()
    {
        String [] duplicate = createDuplicate(this.values);

        return duplicate;
    }

    private static String [] createDuplicate(String [] values)
    {
        String [] duplicate = new String[values.length];
        System.arraycopy(values, 0, duplicate, 0, values.length);
    }
}