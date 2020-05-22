public static List<String> getSubjectAlternativeNames(X509Certificate certificate) {
        List<String> identities = new ArrayList<String>();
        try {
            Collection<List<?>> altNames = certificate.getSubjectAlternativeNames();
            if (altNames == null)
                return Collections.emptyList();
            for (List item : altNames) {
                Integer type = (Integer) item.get(0);
                if (type == 0 || type == 2){
                    try {
                        ASN1InputStream decoder=null;
                        if(item.toArray()[1] instanceof byte[])
                            decoder = new ASN1InputStream((byte[]) item.toArray()[1]);
                        else if(item.toArray()[1] instanceof String)
                            identities.add( (String) item.toArray()[1] );
                        if(decoder==null) continue;
                        DEREncodable encoded = decoder.readObject();
                        encoded = ((DERSequence) encoded).getObjectAt(1);
                        encoded = ((DERTaggedObject) encoded).getObject();
                        encoded = ((DERTaggedObject) encoded).getObject();
                        String identity = ((DERUTF8String) encoded).getString();
                        identities.add(identity);
                    }
                    catch (UnsupportedEncodingException e) {
                        log.error("Error decoding subjectAltName" + e.getLocalizedMessage(),e);
                    }
                    catch (Exception e) {
                        log.error("Error decoding subjectAltName" + e.getLocalizedMessage(),e);
                    }
                }else{
                    log.warn("SubjectAltName of invalid type found: " + certificate);
                }
            }
        }
        catch (CertificateParsingException e) {
            log.error("Error parsing SubjectAltName in certificate: " + certificate + "\r\nerror:" + e.getLocalizedMessage(),e);
        }
        return identities;
    }