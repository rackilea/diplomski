Map<String, String> certificates = new HashMap<String, String>();
    certificates.put("CE1", "AAAA"); 
    certificates.put("CE2", "BBBB");
    certificates.put("CE3", "CCCC");
    List<String> selectedCertificates = new ArrayList<String>();
    selectedCertificates.add("CE1");
    selectedCertificates.add("CE2");

    List<String> result = new ArrayList<String>();


    for (String certificate : selectedCertificates) { 

        String certificateValue = certificates.get(certificate);
        result.add(certificateValue);
    }



    System.out.println(result);