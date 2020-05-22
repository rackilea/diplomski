for (Path path : t) {
    GraphPath gp = new GraphPath();
    Person person = null;
    Connection connection = null;

    for (PropertyContainer pc : path) {
        if (pc instanceof Node) {
            Node node = (Node) pc;

            person = new Person();
            person.setId(node.getId());
            person.setFullName(node.getProperty("name", null));
            person.setStatus(node.getProperty("status", null));
            gp.getPersons().add(person);

            // No connection exists for the first node in the path
            if (connection != null) {
                // Find out which end has already been connected
                if (connection.getPersonSource() == null) {
                    connection.setPersonSource(person);
                } else {
                    connection.setPersonTarget(person);
                }
                person.getPersonConnections().add(connection);
            }
        } else {
            Relationship rel = (Relationship) pc;

            connection = new Connection();
            connection.setId(rel.getId());
            connection.setConnectId(rel.getProperty("connection_id", null));
            connection.setStatus(rel.getProperty("status", null));
            gp.getConnections().add(connection);

            // Find out which end has already been mapped
            if (rel.getStartNode().getId() == person.getId().longValue()) {
                connection.setPersonSource(person);
            } else {
                connection.setPersonTarget(person);
            }
            person.getPersonConnections().add(connection);
        }
    }
}