public static void main(String[] args) {
        final XStream xstream = new XStream();
        xstream.processAnnotations(Parent.class);

        // Deserialize
        final String xml = "<parent><message><type>15</type></message></parent>";
        final Parent parent = (Parent) xstream.fromXML(xml);
        System.out.println(parent.getMessage());
    }