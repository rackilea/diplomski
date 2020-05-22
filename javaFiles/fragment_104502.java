const unsigned char private_key[] = {0x30,...};
size_t private_key_len = sizeof(private_key);
char* buf = (char*)malloc(private_key_len);
memcpy(buf, private_key, private_key_len);
BIO* mem=BIO_new_mem_buf(buf, private_key_len);
PKCS8_PRIV_KEY_INFO* p8inf = d2i_PKCS8_PRIV_KEY_INFO_bio(mem, NULL);
EVP_PKEY* pkey = EVP_PKCS82PKEY(p8inf);
RSA* r = EVP_PKEY_get1_RSA(pkey);