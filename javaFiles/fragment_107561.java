public interface FileUploadResource {

    @RequestLine("POST /upload")
    @Headers("Content-Type: multipart/form-data")
    Response uploadFile(@Param("name") String name, @Param("file") File file);

}