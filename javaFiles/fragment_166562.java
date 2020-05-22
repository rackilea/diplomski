public static String get_otp2()
{
    final SecureRandom rng = new SecureRandom();
    String out = "";
    for (int i = 0; i < 9; i++)  {
        if(i > 0 && i % 3 == 0)
            out += '-';
        out += (char)('a' + rng.nextInt(26));
    }
    return out;
}