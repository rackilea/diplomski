// Use CertEnumCertificatesInStore to get the certificates
// from the open store. pCertContext must be reset to
// NULL to retrieve the first certificate in the store.
while (pCertContext = ::CertEnumCertificatesInStore(hCertStore, pCertContext))
{
    // Check if private key available - client authentication certificate
    // must have private key available.
    HCRYPTPROV hCryptProv = NULL;
    DWORD dwKeySpec = 0;
    HCRYPTKEY hUserKey = NULL;
    BOOL bCallerFreeProv = FALSE;
    BOOL bHasNoPrivateKey = FALSE;
    DWORD dwPublicKeyLength = 0;

    if (::CryptAcquireCertificatePrivateKey(pCertContext, NULL, NULL,
                                            &hCryptProv, &dwKeySpec, &bCallerFreeProv) == FALSE)
    {
        bHasNoPrivateKey = TRUE;

    } else {
        // Private key is available

    BOOL bGetUserKey = ::CryptGetUserKey(hCryptProv, dwKeySpec, &hUserKey);

    // Skip certificate if cannot find private key
    if (bGetUserKey == FALSE)
    {
        if (bCallerFreeProv)
            ::CryptReleaseContext(hCryptProv, NULL);

        continue;
    }
    ....