String toVerify = "A1005056807CE11EE2B4CE0025305725CFrCN%3DKED,OU%3DI0020266601,OU%3DSAPWebAS,O%3DSAPTrustCommunity,C%3DDE20130611102236";
    String signed = "MIIBUQYJKoZIhvcNAQcCoIIBQjCCAT4CAQExCzAJBgUrDgMCGgUAMAsGCSqGSIb3DQEHATGCAR0wggEZAgEBMG8wZDELMAkGA1UEBhMCREUxHDAaBgNVBAoTE1NBUCBUcnVzdCBDb21tdW5pdHkxEzARBgNVBAsTClNBUCBXZWIgQVMxFDASBgNVBAsTC0kwMDIwMjY2NjAxMQwwCgYDVQQDEwNLRUQCByASEgITMlYwCQYFKw4DAhoFAKBdMBgGCSqGSIb3DQEJAzELBgkqhkiG9w0BBwEwHAYJKoZIhvcNAQkFMQ8XDTEzMDYxMTA4MjM1MVowIwYJKoZIhvcNAQkEMRYEFGy7jXb/pUqMYdk2dss2Qe6hNroaMAkGByqGSM44BAMELjAsAhRMJ+t5/3RxQAsHKnIoPY4BnO0qCAIUAbKRwWNjOYsewB56zoZqnZwRyWw=";
    byte[] signedByte = Base64.decode(signed);

    Security.addProvider(new BouncyCastleProvider());

    CMSSignedData s = new CMSSignedData(new CMSProcessableByteArray(toVerify.getBytes()), signedByte);
    SignerInformationStore signers = s.getSignerInfos();
    SignerInformation signerInfo = (SignerInformation)signers.getSigners().iterator().next();

    FileInputStream fis = new FileInputStream("c:\\sap.cer");
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509Certificate cert = (X509Certificate)cf.generateCertificates(fis).iterator().next();

    boolean result = signerInfo.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider("SUN").build(cert.getPublicKey())); 
    System.out.println("Verified: "+result);