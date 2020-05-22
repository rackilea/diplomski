byte[] finalBytes = cipher.doFinal();

byte[] finalBytesPadded = new byte[16];

for (int i = 0; i < finalBytes.length; i++)
{
    finalBytesPadded[i] = finalBytes[i];
}

for (int i = finalBytes.length; i < 16; i++)
{
    finalBytesPadded[i] = (byte)(16 - finalBytes.length);
}

decryptedFileStream.write(finalBytesPadded);