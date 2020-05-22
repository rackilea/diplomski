@Provider
public class XmlContextProvider implements ContextResolver<JAXBContext> {
    private JAXBContext context = null;

    public JAXBContext getContext(Class<?> type) {
        if (type != TestClass.class) {
            return null; // we don't support nothing else than TestClass
        }

        if (context == null) {
            try {
                context = JAXBContext.newInstance(TestClass.class);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return context;
    }
}