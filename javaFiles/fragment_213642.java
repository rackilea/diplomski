boolean check (Certificate testCert, Certificate caCert)
{
    try
    {
        testCert.verify(caCert.getPublicKey());
        return true;
    }
    catch (GeneralSecurityException e)
    {
        return false;
    }
]