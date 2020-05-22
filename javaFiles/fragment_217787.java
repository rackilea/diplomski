Relationship relationship = neo4jTemplate.getRelationship(id);
        String type = (String) relationship.getProperty("__type__");
        if (!type.equals(nodeClass.getName())) {
            throw new ResultNotFoundException("No such object (" + nodeClass.getSimpleName() + ": id=" + id + ") in database");
        }
        return neo4jTemplate.projectTo(relationship, nodeClass);