public class HttpResponseCatcher extends HttpServletResponseWrapper {

    private ByteArrayOutputStream buffer;

    public HttpResponseCatcher(HttpServletResponse res) {
        super(res);
        this.buffer = new ByteArrayOutputStream();
    }

    //There is some more code in the class, but that is not relevant to the problem...
    public byte[] getByteArray() {
        //The problem is here... this.buffer.toString().getBytes() changes to encoding of the data      
        return this.buffer.toString().getBytes();
    }
}