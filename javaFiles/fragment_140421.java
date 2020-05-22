@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "request")
public class Request {

    private static class EmtpyStringAdapter
        extends XmlAdapter<String, Integer> {

        @Override
        public Integer unmarshal(final String value) throws Exception {
            if (value == null || value.isEmpty()) {
                return null;
            }
            return Integer.valueOf(value);
        }

        @Override
        public String marshal(final Integer bound) throws Exception {
            if (bound == null) {
                return null;
            }
            return bound.toString();
        }
    }

    public static void main(final String[] args) throws JAXBException {

        final JAXBContext context = JAXBContext.newInstance(Request.class);

        {
            final Request request1 = new Request();
            request1.setIntTag(0);

            final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                                   Boolean.TRUE);
            marshaller.marshal(request1, System.out);
            marshaller.marshal(request1, buffer);

            final Unmarshaller unamrshaller = context.createUnmarshaller();
            final Request request2 = (Request) unamrshaller.unmarshal(
                new ByteArrayInputStream(buffer.toByteArray()));
            System.out.println(request2.getIntTag());
        }

        {
            final Request request1 = new Request();
            request1.setIntTag(null);

            final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                                   Boolean.TRUE);
            marshaller.marshal(request1, System.out);
            marshaller.marshal(request1, buffer);

            final Unmarshaller unamrshaller = context.createUnmarshaller();
            final Request request2 = (Request) unamrshaller.unmarshal(
                new ByteArrayInputStream(buffer.toByteArray()));
            System.out.println(request2.getIntTag());
        }

        {
            final String xml = "<request><intTag></intTag></request>";
            final Unmarshaller unamrshaller = context.createUnmarshaller();
            final Request request2 =
                (Request) unamrshaller.unmarshal(new StringReader(xml));
            System.out.println(request2.getIntTag());
        }
    }

    @XmlElement(nillable = true, required = true)
    @XmlJavaTypeAdapter(EmtpyStringAdapter.class)
    public Integer getIntTag() {
        return intTag;
    }

    public void setIntTag(Integer intTag) {
        this.intTag = intTag;
    }

    private Integer intTag;
}