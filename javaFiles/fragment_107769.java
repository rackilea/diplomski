String toFind = "anotherName";

Iterator<JsonNode> iter = responseAsNode.elements();

while (iter.hasNext())
{
    JsonNode node = iter.next();

    JsonNode name = node.get("name");

    if (toFind.equals(name.asText()))
    {
        System.out.println(node.get("id").asLong());
    }

}