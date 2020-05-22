Document doc = DocumentHelper
            .parseText("<x:fish xmlns:x='42'>Goodbye, and thanks for all the fish</x:fish>");
    XPath xpath = new DefaultXPath("local-name(/*[1])");
    Object result = xpath.evaluate(doc);
    System.out.printf("Type: %s, Value: %s\n", result.getClass()
            .getSimpleName(), result);