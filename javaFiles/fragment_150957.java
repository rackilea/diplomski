public class DurationConverter extends BeanConverter {

    @Override
    public Duration convertInbound(Class<?> type, InboundVariable iv, InboundContext ic) throws MarshallException {
        String value = iv.getValue();

        // If the text is null then the whole bean is null
        if (value == null) {
            return null;
        }

        Duration duration = null;
        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            duration = df.newDuration(Long.valueOf(value));

        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DurationConverter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return duration;
    }

    @Override
    public OutboundVariable convertOutbound(Object o, OutboundContext oc) throws MarshallException {
        Duration duration = (Duration) o;
        String varname = oc.getNextVariableName();
        Map<String, OutboundVariable> ovs = new TreeMap<>();
        OutboundVariable durationOV = getConverterManager().convertOutbound(duration.getSeconds(), oc); 

        ovs.put("duration", durationOV);

        ObjectJsonOutboundVariable oj = new ObjectJsonOutboundVariable();
        oj.setChildren(ovs);

        return oj;
    }
}