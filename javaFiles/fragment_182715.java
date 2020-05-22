$ cd openssl-1.0.2-src
$ grep -R X509_subject_name_hash *
...
crypto/x509/x509.h:unsigned long X509_subject_name_hash(X509 *x);
crypto/x509/x509.h:unsigned long X509_subject_name_hash_old(X509 *x);
crypto/x509/x509_cmp.c:unsigned long X509_subject_name_hash(X509 *x)
crypto/x509/x509_cmp.c:unsigned long X509_subject_name_hash_old(X509 *x)
...