ArrayNode arrayNodeRecProducts = (ArrayNode) recProducts;
if (limit >= 0 && limit < arrayNodeRecProducts.size()) {
    Field innerArrayNode = ArrayNode.class.getDeclaredField("_children");
    innerArrayNode.setAccessible(true);
    List<JsonNode> innerArrayNodeChildNodes = (List<JsonNode>) innerArrayNode.get(arrayNodeRecProducts);
    List<JsonNode> limitedChildNodes = innerArrayNodeChildNodes.subList(0, limit);
    innerArrayNode.set(arrayNodeRecProducts, limitedChildNodes);
}