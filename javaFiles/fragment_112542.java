public static boolean isValidPassword(String pass)
{
    if (pass.length() < 8) return false;

    int symbolOrNumberCount = 0;
    String symbols = "0123456789-+_!@#$%^&*.,?";

    for (int i = 0; i < pass.length(); ++i)
    {
        if (symbols.indexOf((int) pass.charAt(i)) != -1)
        {
            symbolOrNumberCount++;
        }
    }

    return symbolOrNumberCount >= 2;
}