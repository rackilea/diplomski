@RequestMapping(path = "/uploadFile", method = RequestMethod.POST,
            consumes = "application/*")
    public String getUploadedFile(@RequestParam("file") String file,
            @RequestParam("procesoId") Integer procesoId, @RequestParam("fuenteId") Integer fuenteId) throws IOException {

        byte[] fileDecoded = DatatypeConverter.parseBase64Binary(file);
        utilitarioServicio.getUploadedFile(fileDecoded, fuenteId, procesoId);

        return "";
    }