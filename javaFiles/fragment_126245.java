public Node update(Node node, Long nodeId) throws EntityNotFoundException {
    Node updated = findById(nodeId, 0);
    updated.setDescription(node.getDescription());
    updated.setType(node.getType());
    updated.setName(node.getName());
    updated.setCode(node.getCode());
    //added param depth=0 here
    nodeRepository.save(updated, 0);
    return updated;
}