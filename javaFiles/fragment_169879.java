@RequestMapping(value="imageuploadsubmit", method=RequestMethod.POST) 
public void addFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (!ServletFileUpload.isMultipartContent(request)) {

    if (!(request instanceof DefaultMultipartHttpServletRequest)){
        throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
    }

    DefaultMultipartHttpServletRequest dmhsRequest = (DefaultMultipartHttpServletRequest) request ;
    MultipartFile multipartFile = (MultipartFile) dmhsRequest.getFile("image");

    //make traitment like a File object
}