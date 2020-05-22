TrustManagerFactory tmf = TrustManagerFactory.getInstance("PKIX");
KeyStore ks = KeyStore.getInstance("JKS");
FileInputStream in = new FileInputStream("<path to your key store>");
ks.load(in, "password".toCharArray());
in.close();
tmf.init(ks);
TrustManager[] tms = tmf.getTrustManagers();