import org.simpleframework.xml.Element;
    import org.simpleframework.xml.Namespace;
    import org.simpleframework.xml.Root;

    @Root(name = "S:Envelope" ,strict = false)
    @Namespace(prefix = "S", reference = "http://schemas.xmlsoap.org/soap/envelope/")
    public class BuyResponseEnvelope {

        @Element(name = "Body")
        private BuyResponseBody body;

        public BuyResponseBody getBody() {
            return body;
        }

        public void setBody(BuyResponseBody body) {
            this.body = body;
        }


    }