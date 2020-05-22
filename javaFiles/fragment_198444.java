public static void main(String[] args) throws IOException {
    String jsonString = "{\"name\":\"Altaf Java\",\"salary\":\"12345.67\",\"amount\":98765.43}";
    System.out.println(jsonString);
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode rootNode = objectMapper.readTree(jsonString);
    JsonNode salaryNode = rootNode.get("salary");
    System.out.println("salaryNode.isNumber()=" + salaryNode.isNumber());
    System.out.println("salaryNode.asDouble()="+salaryNode.asDouble());
    System.out.println("salaryNode.doubleValue()="+salaryNode.doubleValue());
    JsonNode amountNode = rootNode.get("amount");
    System.out.println("amountNode.isNumber()=" + amountNode.isNumber());
    System.out.println("amountNode.asDouble()=" + amountNode.asDouble());
    System.out.println("amountNode.doubleValue()=" + amountNode.doubleValue());
}