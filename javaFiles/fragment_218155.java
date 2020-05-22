/*
pkcs11.cfg example:
name=PKCS11
library=vendor provided library absolute path
slot=0
*/
String propertyPath = "/root/IdeaProjects/ssl/pkcs11.cfg;
char[] pin = "1234".toCharArray();
Provider p = new SunPKCS11(propertyPath);
Security.removeProvider("IAIK");
Security.addProvider(p);
KeyStore ks = KeyStore.getInstance("PKCS11",p);
ks.load(null,pin);