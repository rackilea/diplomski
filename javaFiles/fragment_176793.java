private String filterfile(String fileName , String filesTypesallowed) {
    String extension = fileName.substring(fileName.lastIndexOf("."));
    String[] allowedExtensions = filesTypesallowed.split(",");
    if (Arrays.asList(allowedExtensions).contains(extension)) {
        return fileName;
    } 
    return null;    
}