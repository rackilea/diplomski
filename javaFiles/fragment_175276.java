public abstract class PhoneNumber
{
    private int Number;


    public PhoneNumber(int Number)
    {
       this.Number = Number;
    }

    protected int getNumber()
    {
        return Number;
    }

    public void doSmthnWithNumber();
}

public class Mobile extends PhoneNumber
{
    @Override
    public void doSmthnWithNumber()
    {
        int Number = getNumber();
        // Do whatever you want with mobile numbers
    }
}

public class HousePhone extends PhoneNumber
{
    @Override
    public void doSmthnWithNumber()
    {
        int Number = getNumber();
       // Do whatever you want with HousePhone numbers
    }
}