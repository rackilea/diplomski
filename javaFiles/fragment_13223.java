public class ParentConverter implements Converter {
        @Override
        public boolean canConvert(@SuppressWarnings("rawtypes") final Class type) {
            return Parent.class.isAssignableFrom(type);
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer,
                MarshallingContext context) {
            throw new UnsupportedOperationException("unmarshaling only");
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader,
                UnmarshallingContext context) {

            reader.moveDown();
            if (!"message".equals(reader.getNodeName())) {
                throw new ConversionException("Expected message, but was "
                        + reader.getNodeName());
            }
            final StringBuilder message = new StringBuilder();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                buildRecursiveMessage(reader, message);
                reader.moveUp();
            }
            reader.moveUp();

            final Parent parent = new Parent(message.toString());
            return parent;
        }

        private void buildRecursiveMessage(final HierarchicalStreamReader reader,
                final StringBuilder sb) {
            // Build start-tag
            final String nodeName = reader.getNodeName();
            sb.append("<" + nodeName);

            // Build attributes
            final int numAttributes = reader.getAttributeCount();
            if (numAttributes > 0) {
                sb.append(" ");
                for (int i = 0; i < numAttributes; i++) {
                    final String attributeName = reader.getAttributeName(i);
                    final String attributeValue = reader.getAttribute(i);
                    sb.append(attributeName + "=\"" + attributeValue + "\"");

                    final boolean lastAttribute = (i == numAttributes - 1);
                    if (!lastAttribute) {
                        sb.append(", ");
                    }
                }
            }

            // Build children
            final boolean containsChildren = reader.hasMoreChildren();
            final boolean containsValue = !reader.getValue().isEmpty();
            final boolean empty = !containsChildren && !containsValue;

            sb.append(!empty ? ">" : " />");

            if (containsChildren) {
                while (reader.hasMoreChildren()) {
                    reader.moveDown();
                    buildRecursiveMessage(reader, sb);
                    reader.moveUp();
                }
            } else if (containsValue) {
                sb.append(reader.getValue());
            }

            // Build end-tag
            if (!empty) {
                sb.append("</" + nodeName + ">");
            }
        }
    }