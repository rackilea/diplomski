class Request {
    InputStream instream
    OutputStream outstream
    static constraints = {
        instream nullable: false, blank: false
    }
}