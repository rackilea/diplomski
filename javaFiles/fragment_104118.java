public void Hello()
{
    try
    {
        PublicKey publicKey = readPublicKey("public.der");
        PrivateKey privateKey = readPrivateKey("private.der");
        byte[] message = "Hello World".getBytes("UTF8");
        byte[] secret = encrypt(publicKey, message);
        byte[] recovered_message = decrypt(privateKey, secret);
        System.out.println(new String(recovered_message, "UTF8"));
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}