public byte[] aesDecrypt(byte[] data)
{
    IBufferedCipher cipher = CipherUtilities.GetCipher("AES/CBC/PKCS5Padding");
    cipher.Init(false, skey_spec);
    return cipher.DoFinal(data);
}

public byte[] aesEncrypt(byte[] data)
{
    IBufferedCipher cipher = CipherUtilities.GetCipher("AES/CBC/PKCS5Padding");
    cipher.Init(true, skey_spec);
    return cipher.DoFinal(data);
}