@Override
    public String getUploadedFile(MultipartFile file, Integer fuenteId, Integer procesoId) {

        try {
            byte[] fileBytes = file.getBytes();
            String base64Encoded = DatatypeConverter.printBase64Binary(fileBytes);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("file", base64Encoded);
            map.add("procesoId", procesoId.toString());
            map.add("fuenteId", fuenteId.toString());
            HttpEntity<MultiValueMap<String, String>> requestEntity
                    = new HttpEntity<MultiValueMap<String, String>>(map, headers);
            getRestTemplate().postForObject(url + "/uploadFile", requestEntity, String.class);
        } catch (IOException ex) {
            Logger.getLogger(UtilitarioServicioProxyImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }