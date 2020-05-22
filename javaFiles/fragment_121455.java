public class GroupingStaxEventItemWriter<T> extends StaxEventItemWriter<T> {

    private static final String GROUP_IDENTIFIER = "CURRENT_GROUP";

    private Classifier<T, String> classifier;

    private String currentGroup;

    private XMLEventWriter eventWriter;

    private Writer writer;

    @Override
    public void write(List<? extends T> items) throws XmlMappingException, Exception {
        Map<String, List<T>> itemsGroup = new LinkedHashMap<String, List<T>>();
        for (T item : items) {
            String group = classifier.classify(item);
            if (!itemsGroup.containsKey(group)) {
                itemsGroup.put(group, new ArrayList<T>());
            }
            itemsGroup.get(group).add(item);
        }
        for (String group : itemsGroup.keySet()) {
            if (group == null || !group.equals(currentGroup)) {
                if (currentGroup != null) {
                    closeGroup(currentGroup);
                }
                currentGroup = group;
                if (currentGroup != null) {
                    openGroup(currentGroup);
                }
            }
            super.write(itemsGroup.get(group));
        }
    }

    protected void openGroup(String group) throws XMLStreamException, FactoryConfigurationError {
        String groupTagName = group;
        String groupTagNameSpacePrefix = "";
        String groupTagNameSpace = null;
        if (groupTagName.contains("{")) {
            groupTagNameSpace = groupTagName.replaceAll("\\{(.*)\\}.*", "$1");
            groupTagName = groupTagName.replaceAll("\\{.*\\}(.*)", "$1");
            if (groupTagName.contains(":")) {
                groupTagNameSpacePrefix = groupTagName.replaceAll("(.*):.*", "$1");
                groupTagName = groupTagName.replaceAll(".*:(.*)", "$1");
            }
        }
        XMLEventFactory xmlEventFactory = createXmlEventFactory();
        eventWriter.add(xmlEventFactory.createStartElement(groupTagNameSpacePrefix, groupTagNameSpace, groupTagName));
    }

    protected void closeGroup(String group)
            throws XMLStreamException, FactoryConfigurationError {
        String groupTagName = group;
        String groupTagNameSpacePrefix = "";
        if (groupTagName.contains("{")) {
            groupTagName = groupTagName.replaceAll("\\{.*\\}(.*)", "$1");
            if (groupTagName.contains(":")) {
                groupTagNameSpacePrefix = groupTagName.replaceAll("(.*):.*", "$1") + ":";
                groupTagName = groupTagName.replaceAll(".*:(.*)", "$1");
            }
        }
        try {
            writer.write("</" + groupTagNameSpacePrefix + groupTagName + ">");
        } catch (IOException ioe) {
            throw new DataAccessResourceFailureException("Unable to close group: [" + group + "]", ioe);
        }
    }

    @Override
    protected XMLEventWriter createXmlEventWriter(XMLOutputFactory outputFactory, Writer writer)
            throws XMLStreamException {
        this.writer = writer;
        this.eventWriter = super.createXmlEventWriter(outputFactory, writer);
        return eventWriter;
    }

    @Override
    public void open(ExecutionContext executionContext) {
        if (executionContext.containsKey(getExecutionContextKey(GROUP_IDENTIFIER))) {
            currentGroup = executionContext.getString(getExecutionContextKey(GROUP_IDENTIFIER));
        }
        super.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) {
        executionContext.putString(getExecutionContextKey(GROUP_IDENTIFIER), currentGroup);
        super.update(executionContext);
    }

    @Override
    public void close() {
        if (currentGroup != null) {
            try {
                closeGroup(currentGroup);
            } catch (XMLStreamException e) {
                throw new ItemStreamException("Failed to write close tag for element: " + currentGroup, e);
            } catch (FactoryConfigurationError e) {
                throw new ItemStreamException("Failed to write close tag for element: " + currentGroup, e);
            }
        }
        super.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        Assert.notNull(classifier, "Missing required property 'classifier'");
    }

    public void setClassifier(Classifier<T, String> classifier) {
        this.classifier = classifier;
    }

}