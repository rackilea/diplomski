const size_t BIT_LENGTH = 16;
static unsigned char bit_pwd[] = {0x13, 0x4E, 0x83, 0xF4, 0xEC, 0xBC, 0xDD, 0xB4, 0x77, 0xEF, 0x7F, 0x4B, 0xB0, 0xC8, 0x03, 0x1E};
static unsigned char chr_pwd[BIT_LENGTH * 2];

char *getPwd() {
    unsigned char c1 = 0x80;
    unsigned char c2 = c1;
    unsigned char *p = chr_pwd;

    memset(chr_pwd, '\0', BIT_LENGTH * 2);
    for (jint i = 0; i < BIT_LENGTH; i++) {
        if (i % 2 != 0) {
            bit_pwd[i] ^= c1++;
        }
        else {
            bit_pwd[i] ^= c2--;
        }
        p += sprintf((char *) p, "%02X", bit_pwd[i]);
    }
    chr_pwd[BIT_LENGTH * 2] = '\0';
    return (char *) chr_pwd;
}

// You will get real password ("93CEFC75923EA0370B6B04CECA4E7A99") from getPwd method.
_objGetWritableDatabase = env->CallObjectMethod(obj, _midGetWritableDatabase, env->NewStringUTF(getPwd()));