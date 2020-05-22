byte[] digest = md.digest();  
byte[] pBytes = path.getBytes();
int L = digest.length + pBytes.length;
byte[] message = new byte[L];

for (int i=0;i<pBytes.length;i++) {
    message[i] = pBytes[i];
}
for (int i=pBytes.length,n=0; n<digest.length; n++) {
    message[i+n] = digest[n];
}

String sign = new String(Base64.encodeToString(mac.doFinal(message), Base64.NO_WRAP));