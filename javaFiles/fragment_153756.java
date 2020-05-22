public void processIncomingParentObject(IncomingParentObject parentObject) {
    Map<Client,Set<IncomingChildObject>> childObjectsByClient =
        new Map<Client,Set<IncomingChildObject>>();
    for (IncomingChildObject childObject : parentObject.childObjects) {
        Set<Client> clients = registry.clients.get(childObject.name);
        for (Client client : clients) {
            Set<IncomingChildObject> childObjects =
                childObjectsByClient.get(client);
            if (childObjects == null) {
                childObjects = new Set<IncomingChildObject>();
                childObjectsByClient.put(client, childObjects);
            }
            childObjects.add(childObject);
        }
    }
    for (Entry<Client,Set<IncomingChildObject>> e : childObjectsByClient.entrySet()) {
        this.transportLayer.transport(e.getKey(), e.getValue());
    }
}