Class FirstClass
{
    private static int fibonnacciNumber; // This field is private to this class and thus can be only accessed by this class

    public static int getFibonnaciNumber() // A public method can be accessed any place other than your class
    {
        return FirstClass.fibonnacciNumber;
    }
}