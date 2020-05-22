ByteArrayResource resource = new ByteArrayResource(multipartFile.getBytes()){
    @Override
    public String getFilename() {
        return systemFile.getFilenameWithExtension();
    }
};