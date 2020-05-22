public static void main(String... args) {
    byte[] bytes = { 1, -128, -1 }; // check sum is -128 or 0x80 or 128 (unsigned)
    System.out.println("makeCS "+ makeCS(bytes));
    System.out.println("makeCS2 "+ makeCS2(bytes));
    System.out.println("makeCS3 "+ makeCS3(bytes));
}

public static int makeCS(byte... arr) {
    byte cs = 0;
    for (byte b : arr)
        cs += b;
    return cs & 0xFF;
}

public static int makeCS2(byte[] arr)
{
    int cs = 0;
    for (int i = 0; i < arr.length; i++)
    {
        int add = arr[i];
        cs += (0xFF & add);
        cs &= 0xFF;
    }
    return cs;
}

public static short makeCS3(byte[] arr)
{
    short cs = 0;
    for (int i = 0; i < arr.length; i++)
    {
        cs += arr[i];
    }
    return cs;
}