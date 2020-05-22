Properties props = new Properties();
 props.put("name", "nss");
 props.put("nssLibraryDirectory", libDir);
 props.put("nssSecmodDirectory", dbDir);
 props.put("nssModule", "fips");
 props.put("nssDbMode", "readWrite");

 ByteArrayOutputStream out = new ByteArrayOutputStream();
 props.store(out, null);
 ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

 Provider ret = new sun.security.pkcs11.SunPKCS11(in);