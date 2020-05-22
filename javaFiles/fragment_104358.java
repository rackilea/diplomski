for (Element leaf; (leaf = (Element)walker.nextNode()) != null; ) {
    Deque<String> pathQueue = new ArrayDeque<>();
    for (Node node = leaf; node.getNodeType() == Node.ELEMENT_NODE; node = node.getParentNode())
    {
        pathQueue.addFirst(((Element)node).getAttribute("id"));
    }
    myQueueOfDeques.add(pathQueue);
}
System.out.println(myQueueOfDeques);