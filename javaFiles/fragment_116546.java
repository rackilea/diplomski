public class CaseObjectAdapter extends XmlAdapter<JAXBElement, CaseObject> {

@Override
public JAXBElement marshal(CaseObject caseObject) throws Exception {

    JAXBElement<CaseObject> jaxbElement = new JAXBElement(new QName(caseObject.methodThatReturnsAnElementName()), caseObject.getClass(), caseObject);

    return jaxbElement;
}

...