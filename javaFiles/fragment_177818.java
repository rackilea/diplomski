private byte[] Hash(byte[] bytes, byte[] salt)
{   
    HashAlgorithm sha256 = new SHA256CryptoServiceProvider();
    byte[] combined = salt.Concat(bytes).ToArray();
    byte[] hashed = sha256.ComputeHash(combined);
    return hashed;
}