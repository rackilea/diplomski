X509Certificate cert=null;
        FileInputStream fis = new FileInputStream("c:\\aa1.cer");
        BufferedInputStream bis = new BufferedInputStream(fis);

        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        if (bis.available() > 0)
            try{
               cert = (X509Certificate)cf.generateCertificate(bis);
            }
            catch (CertificateException e) {
                e.printStackTrace();
            }
        System.out.println(CertificateInfo.getSubjectAlternativeNames(cert));