RSAParameters keyParams = rsa.ExportParameters(false);

if (!keyParams.Exponent.SequenceEqual(new byte[] { 0x01, 0x00, 0x01 }))
    throw new InvalidOperationException();

Send(keyParams.Modulus);