StringBuilder outputBuilder = new StringBuilder();
for (String quote : data) {
    outputBuilder.append(quote);
    outputBuilder.append(", ");
}
String output = outputBuilder.toString();

// Remove last comma
output = output.substring(0, output.length() - ", ".length());

requestSpecificationFacade.body("{\n" +
           " \"quoteId\": " + output +  "\n" +
                                            "}");