public class MyMarshaller implements IMarshaller {
    private static final String FUNCTION_ELEMENT_NAME = "Function";
    private static final String SUB_FUNCTION_ELEMENT_NAME = "SubFunction";
    private static final String OPERATION_ELEMENT_NAME = "Operation";

    private String m_uri;
    private int m_index;
    private String m_name;

    public MyMarshaller() {
        m_uri = null;
        m_index = 0;

        m_name = "Function";
    }

    public MyMarshaller(String uri, int index, String name) {
        m_uri = uri;
        m_index = index;
        m_name = name;
    }

    public boolean isExtension(int index) {
        return false;
    }

    public void marshal(Object obj, IMarshallingContext ictx)
            throws JiBXException {

        // make sure the parameters are as expected
        if (!(obj instanceof BaseForm)) {
            throw new JiBXException("Invalid object type for marshaller");
        } else if (!(ictx instanceof MarshallingContext)) {
            throw new JiBXException("Invalid object type for marshaller");
        } else {
            // start by generating start tag for container
            MarshallingContext ctx = (MarshallingContext) ictx;
            BaseForm formBean = (BaseForm) obj;

            /*
             * THIS CODE COULD BE REPEATED FOR ALL FormBean CLASS' ATTRIBUTE USING REFLECTION.
             * And to control which attributes should be marshalled the attributes could follow special nomeclatures.
             * Ex.
             * class FormBean { 
             *    String marshallable_Function;
             *    String non_marshallable_Function;
             * }
             */ 
            writeTag(ctx, formBean.getFunction(), FUNCTION_ELEMENT_NAME);
            writeTag(ctx, formBean.getSubFunction(), SUB_FUNCTION_ELEMENT_NAME);
            writeTag(ctx, formBean.getOperation(), OPERATION_ELEMENT_NAME);
        }
    }

    private void writeTag(MarshallingContext ctx, String value, String entryElementName)
            throws JiBXException {
        ctx.startTag(m_index, entryElementName);
        ctx.closeStartContent();
        ctx.content(value);
        ctx.endTag(m_index, entryElementName);
    }
}