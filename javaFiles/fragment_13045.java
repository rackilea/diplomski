static class MyNamespaceContext implements NamespaceContext {

    @Override
    public String getNamespaceURI(String prefix) {
        switch (prefix) {
        case "location":
            return "http://www.csapi.org/schema/parlayx/terminal_location/v2_3/local";
        }
        return null;
    }

    @Override
    public String getPrefix(String namespaceURI) {
        return null;
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        return null;
    }

}