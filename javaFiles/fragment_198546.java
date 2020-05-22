@Client(value ="/v1/upload")
static interface UploadClient {

  @Post(uri = "/mailings", produces = MediaType.MULTIPART_FORM_DATA)
  HttpResponse postFile(@Body MultipartBody file)

}