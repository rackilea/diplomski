public class MyData implements IntegerConvert
{
    private String data;

    public MyData(String data)
    {
        this.data = data;
    }

    @Override
    public Integer returnAsInteger()
    {
        return Integer.parseInt(data); //throws ParseException if it doesn't work
    }
}