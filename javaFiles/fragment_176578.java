public class ParseXML {
        public static void main(String[] args) {
            final OptionsParser handler = new OptionsParser();
            try {
                SAXParserFactory.newInstance().newSAXParser()
                        .parse("C:/luna/sample/inputs/options.xml", handler);
            } catch (SAXException | IOException | ParserConfigurationException e) {
                System.err.println("Somethig went wrong while parsing the input file the exception is -- " + e.getMessage() + " -- ");
            }
            Map<String, Option> result = handler.getResultAsMap();
            Collection<Option> values = result.values();
            for (Option option : values) {
                System.out.println(option.getName());
            }

        }
    }