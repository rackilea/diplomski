@WebService(serviceName = "SOS")//, targetNamespace = "http://www.opengis.net/sos/1.0")
@UsesJAXBContext(value = SosServices.SosJaxbContext.class)
//@XmlSeeAlso({net.opengis.sos.v_1_0_0.filter.v_1_1_0.ObjectFactory.class, net.opengis.sensorml.v_1_0_1.ObjectFactory.class})
public class SosServices {

@WebMethod(operationName = "GetResult")
    public GetResultResponse getResult(GetResult request) {
        throw new UnsupportedOperationException();
    }

public static class SosJaxbContext implements JAXBContextFactory {

        @Override
        public JAXBRIContext createJAXBContext(SEIModel sei,
                List<Class> classesToBind, List<TypeReference> typeReferences)
                throws JAXBException {

            List<Class> classList = new ArrayList<Class>();
            classList.addAll(classesToBind);
            classList.add(TemporalOpsType.class);

            List<TypeReference> refList = new ArrayList<TypeReference>();
            refList.addAll(typeReferences);
            refList.add(new TypeReference(new QName("http://www.opengis.net/ogc", "temporalOps"), TemporalOpsType.class));

            return JAXBRIContext.newInstance(classList.toArray(new Class[classList.size()]),
                    refList, null, sei.getTargetNamespace(), false, null);
        }
    }
}