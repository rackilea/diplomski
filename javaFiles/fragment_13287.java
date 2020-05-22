KeyStore keyStore = KeyStore.getInstance("BKS",
                                                         BouncyCastleProvider.PROVIDER_NAME);
                byteArrayInputStream = new ByteArrayInputStream(keyStoreBytes);
                keyStore.load(byteArrayInputStream, keyStorePassword);
                Certificate[] certificates = keyStore.getCertificateChain("theCertAlias");
                Certificate certificate = certificates[0];