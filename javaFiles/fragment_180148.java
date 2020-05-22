public String xorEnc(int encKey, String toEnc) {
    /*
        Usage: str = xorEnc(integer_key,string_to_encrypt);
        Created by Matthew Shaffer (matt-shaffer.com)
    */
    int t=0;
    String s1="";
    String tog="";
    if(encKey>0) {
        while(t < toEnc.length()) {
            int a=toEnc.charAt(t);
            int c=a ^ encKey;
            char d=(char)c;
            tog=tog+d;
            t++;
        }

    }
    return tog;
}
public String xorEncStr(String encKey, String toEnc) {
    /*
        Usage: str = xorEnc(string_key,string_to_encrypt);
        Created by Matthew Shaffer (matt-shaffer.com)
    */
    int t=0;
    int encKeyI=0;

    while(t < encKey.length()) {
        encKeyI+=encKey.charAt(t);
        t+=1;
    }
    return xorEnc(encKeyI,toEnc);
}