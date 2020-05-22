Node node = neo4jTemplate.getNode(id);
        String type = (String) node.getProperty("__type__");
        if (!type.equals(nodeClass.getName())) {
            throw new ResultNotFoundException("No such object (" + nodeClass.getSimpleName() + ": id=" + id + ") in database");
        }
        return neo4jTemplate.projectTo(node, nodeClass);