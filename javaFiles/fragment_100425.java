Rfc2898DeriveBytes rfc2898 = new Rfc2898DeriveBytes("gygp6yevKWKBUwFy4GXpuFwT", salt, iterations);
>>>  byte[] key = rfc2898.GetBytes(24);      

     AesManaged aesCipher = new AesManaged();
>>>  aesCipher.KeySize = 256;
     aesCipher.BlockSize = 128;
     aesCipher.Mode = CipherMode.CBC;
     aesCipher.Padding = PaddingMode.PKCS7;
>>>  aesCipher.Key = key;