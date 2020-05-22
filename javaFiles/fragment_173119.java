//grabs fxml file relative to root of the jar
FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemClassLoader().getResource("app.fxml"));
Parent javaFXRoot = (Parent) loader.load();

public Node findWidgetByID(String id, Parent javaFXRoot)
{
    return findObject(root, id);
}

private Node findObject(Parent root, String id)
{
    for (Node node : root.getChildrenUnmodifiable())
    {
        if (node.getId() != null && node.getId().equals(id))
        {
            return node; // found the node, return it
        }
        Node retValue = null;
        if (node instanceof Parent)
        {
            retValue = findObject(((Parent) node), id); // recursive search
        }
        if (retValue != null) //if our node was found by the recursive search, return that
        {
            return retValue;
        }
    }
    return null;
}