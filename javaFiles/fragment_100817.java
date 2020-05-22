char[] pw = "password".toCharArray(); // dummy for test
boolean useBC = System.getProperty("useBC")!=null;
KeyStore jks = KeyStore.getInstance("JKS");
InputStream f1 = new FileInputStream ("old.jks"); jks.load(f1, pw); f1.close();
PrivateKey pkey = (PrivateKey)jks.getKey("mykey", pw);
Certificate[] chain = jks.getCertificateChain("mykey");

// only needed once, and not at all if pre-configured in java.security  
if(useBC) Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

// then do something like this
KeyStore p12 = useBC? KeyStore.getInstance("PKCS12","BC"): KeyStore.getInstance("PKCS12");
p12.load(null); p12.setKeyEntry("mykey", pkey, pw, chain);
OutputStream f2 = new FileOutputStream ("new.p12"); p12.store(f2,pw); f2.close();