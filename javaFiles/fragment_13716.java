KeyStore ks = KeyStore.getInstance("PKCS12");
FileInputStream file = new FileInputStream(<path to .pfx file>);
ks.load(file, <password>);
String alias = (String)ks.aliases().nextElement();

PrivateKey key = (PrivateKey)ks.getKey(alias, ConstantsUtils.CERT_PASS.toCharArray());
Certificate[] chain = ks.getCertificateChain(alias);