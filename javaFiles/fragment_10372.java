public static byte[] printHexadecimalHashIterations(byte[] input, int iterations)
{
    var digest = input.clone();

    MessageDigest md;
    try
    {
        md = MessageDigest.getInstance("SHA-256");
    }
    catch (NoSuchAlgorithmException e)
    {
        throw new IllegalStateException("SHA-256 hash should be available", e);
    }

    for (int i = 0; i < iterations; i++)
    {
        md.update(digest);
        digest = md.digest();

        printDigest("Intermediate hash", digest);
    }

    printDigest("Final hash", digest);

    return digest;
}

public static void printDigest(String hashType, byte[] digest)
{
    var digestInHex = toHex(digest);
    System.out.printf("%s: %s%n", hashType, digestInHex);
}

public static String toHex(byte[] data)
{
    var sb = new StringBuilder(data.length * 2);
    for (int i = 0; i < data.length; i++)
    {
        sb.append(String.format("%02X", data[i]));
    }
    return sb.toString();
}

public static void main(String[] args)
{
    printHexadecimalHashIterations("password".getBytes(StandardCharsets.UTF_8), 2);
}