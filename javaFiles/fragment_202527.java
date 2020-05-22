package test;

public enum Enum
{

    e1(0),
    e2(1),
    e3(SPECIAL_VALUE());

    static int SPECIAL_VALUE(){return -1;}

    int value;

    private Enum(int value)
    {
        this.value = value;
    }
    public int getValue()
    {
        return value;
    }

    public static void main(String args[])
    {
        System.out.println(e3.name());
        System.out.println(e3.getValue());
    }
}