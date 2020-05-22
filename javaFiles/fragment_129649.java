UChar *utf16 = (UChar*) malloc(len16 * sizeof(UChar));
//TODO: fill data
// convert to UTF-8
UConverter *encoding = ucnv_open("UTF-8", &status);
int len8 = ucnv_fromUChars(encoding, NULL, 0, utf16, len16, &status);
char *utf8 = (char*) malloc(len8 * sizeof(char));
ucnv_fromUChars(encoding, utf8, len8, utf16, len16, &status);
ucnv_close(encoding);
//TODO: char to jbyte