class BarcodeController {
    def index = {
        def img // byte array, set this to the binary contents of your image

        response.setHeader('Content-length', img.length)
        response.contentType = 'image/png' // or the appropriate image content type
        response.outputStream << img
        response.outputStream.flush()
    }
}