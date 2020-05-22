abstract class GetNames implements xxx
{
    @Override
    public String names()
    {
        return "Ravi";
    }
}

class Check extends GetNames
{
    @Override
    public int numbers()
    {
        return 3;
    }
    public double sal()
    {
        return 25000.00;
    }
    @Override
    public Double salary() {
        return sal();
    }

    @Override
    public String names() { // this overrides names() method in GetNames class
        return "Check";
    }


}