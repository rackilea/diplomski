public void indexRootNode(Node node, Class rootNodeClass)
{
    Field idField = rootNodeClass.getField("ID");
    Object idValue = idField.get(null);
    Field roorField = rootNodeClass.getField("ROOT");
    Object rootValue = rootField.get(null);

    indexService.index(node, idValue, rootValue);
}