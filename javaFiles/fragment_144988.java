JsonNode rootNode = mapper.readTree(DATA1);

JsonNode metric_node = rootNode.path("metrics");
Iterator<Map.Entry<String, JsonNode>> iterator  = metric_node.fields();
while (iterator.hasNext()) {
    Map.Entry<String, JsonNode> next = iterator.next();
    System.out.println("class_name=> = " + next.getKey());
    System.out.println("content=> = " + next.getValue());
    System.out.println();
}