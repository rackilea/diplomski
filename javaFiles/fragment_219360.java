public abstract class XmlElement implements Serializable {
    protected static Document elementGenerator = createElementGenerator();

    protected static Document createElementGenerator() {
        try {
            elementGenerator = documentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            StateController.getInstance().addLog(new Log(Log.Type.ERROR, "Couldn't load XML parser: " + e));
            System.exit(1);
        }
    }

    public abstract Element toXML();
    public abstract void fromXML(Element element);
    protected abstract String getTag();
}