private void wrapUnwrappedTextInTagP(Element element) {
    List<NodesToProcess> nodesToProcesses = new ArrayList<>();
    List<Node> nodeAlreadyUsed = new ArrayList<>();

    element.childNodes().forEach(node -> {
        if(node instanceof TextNode && !nodeAlreadyUsed.contains(node)) {
            List<Node> newChilds = new ArrayList<>();
            List<Node> toRemove = new ArrayList<>();

            newChilds.add(node);
            nodeAlreadyUsed.add(node);
            Node auxNode = node.nextSibling();

            while (auxNode != null && parentIsBodyAndIsAnTextElement(auxNode)) {
                newChilds.add(auxNode);
                nodeAlreadyUsed.add(auxNode);
                toRemove.add(auxNode);
                auxNode = auxNode.nextSibling();
            }
            nodesToProcesses.add(new NodesToProcess(node, new NewNode(newChilds), toRemove));
        }
    });

    nodesToProcesses.forEach(nodesToProcess -> {
        nodesToProcess.getOldNode().replaceWith(nodesToProcess.getNewNode());
        nodesToProcess.getToRemove().forEach(node -> node.remove());
    });
}