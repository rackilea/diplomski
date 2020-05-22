protected static XPath parse(String text) {
    try {
        return new Dom4jXPath(text);
    } catch (JaxenException e) {
        throw new InvalidXPathException(text, e.getMessage());
    } catch (Throwable t) {
        throw new InvalidXPathException(text, t);
    }
}