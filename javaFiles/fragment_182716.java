unsigned long X509_subject_name_hash(X509 *x)
{
    return (X509_NAME_hash(x->cert_info->subject));
}

#ifndef OPENSSL_NO_MD5
unsigned long X509_subject_name_hash_old(X509 *x)
{
    return (X509_NAME_hash_old(x->cert_info->subject));
}
#endif