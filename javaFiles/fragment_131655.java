@Controller
@RequestMapping(value = Array("/upload"))
class UploadController  {

    @RequestMapping(value = Array("/good"), method = Array(POST))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    def goodUpload(body: InputStream) {
        //...
    }

    @RequestMapping(value = Array("/bad"), method = Array(POST))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    def badUpload(@RequestBody body: Array[Byte]) {
        //...
    }

}