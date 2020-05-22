unsigned long X509_NAME_hash(X509_NAME *x)
{
    unsigned long ret = 0;
    unsigned char md[SHA_DIGEST_LENGTH];

    /* Make sure X509_NAME structure contains valid cached encoding */
    i2d_X509_NAME(x, NULL);
    if (!EVP_Digest(x->canon_enc, x->canon_enclen, md, NULL, EVP_sha1(),
                    NULL))
        return 0;

    ret = (((unsigned long)md[0]) | ((unsigned long)md[1] << 8L) |
           ((unsigned long)md[2] << 16L) | ((unsigned long)md[3] << 24L)
        ) & 0xffffffffL;
    return (ret);
}

#ifndef OPENSSL_NO_MD5
unsigned long X509_NAME_hash_old(X509_NAME *x)
{
    EVP_MD_CTX md_ctx;
    unsigned long ret = 0;
    unsigned char md[16];

    /* Make sure X509_NAME structure contains valid cached encoding */
    i2d_X509_NAME(x, NULL);
    EVP_MD_CTX_init(&md_ctx);
    EVP_MD_CTX_set_flags(&md_ctx, EVP_MD_CTX_FLAG_NON_FIPS_ALLOW);
    if (EVP_DigestInit_ex(&md_ctx, EVP_md5(), NULL)
        && EVP_DigestUpdate(&md_ctx, x->bytes->data, x->bytes->length)
        && EVP_DigestFinal_ex(&md_ctx, md, NULL))
        ret = (((unsigned long)md[0]) | ((unsigned long)md[1] << 8L) |
               ((unsigned long)md[2] << 16L) | ((unsigned long)md[3] << 24L)
            ) & 0xffffffffL;
    EVP_MD_CTX_cleanup(&md_ctx);

    return (ret);
}
#endif