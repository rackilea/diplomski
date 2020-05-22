public void testHardCopyBytes()
{
    byte[] bytes = new byte[0x5000000]; /*~83mb buffer*/
    byte[] out = new byte[bytes.length];
    for(int i = 0; i < out.length; i++)
    {
        out[i] = bytes[i];
    }
}

public void testArrayCopyBytes()
{
    byte[] bytes = new byte[0x5000000]; /*~83mb buffer*/
    byte[] out = new byte[bytes.length];
    System.arraycopy(bytes, 0, out, 0, out.length);
}