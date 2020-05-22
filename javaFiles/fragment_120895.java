public static Guid NameGuidFromBytes(byte[] input)
{
    MD5 md5 = MD5.Create();
    byte[] hash = md5.ComputeHash(input);
    hash[6] &= 0x0f;
    hash[6] |= 0x30;
    hash[8] &= 0x3f;
    hash[8] |= 0x80;

    byte temp = hash[6];
    hash[6] = hash[7];
    hash[7] = temp;

    temp = hash[4];
    hash[4] = hash[5];
    hash[5] = temp;

    temp = hash[0];
    hash[0] = hash[3];
    hash[3] = temp;

    temp = hash[1];
    hash[1] = hash[2];
    hash[2] = temp;
    return new Guid(hash);
}