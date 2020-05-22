if (crl.getNextUpdate().after(validityDate))
    {
        X509Certificate cert = crlselect.getCertificateChecking();

        if (cert != null)
            {
            if (crl.getThisUpdate().before(cert.getNotAfter()))
            {
                finalSet.add(crl);
            }
        }
        else
        {
            finalSet.add(crl);
        }
}