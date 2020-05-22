// index = character, value = index of character from base64Order
private static final int[] base64ToInt = new int[128];

public static void initBase64ToIntTable()
{
    for (int i = 0; i < base64Order.length; i++)
    {
        base64ToInt[base64Order[i]] = i;
    }
}