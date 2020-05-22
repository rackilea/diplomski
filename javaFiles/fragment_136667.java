public static boolean buildTree(GenericTreeNode<String> inputNode) {
    if (interruptFlag) {
        // search was interrupted
        // answer has not be found yet
        return false;
    }

    boolean something = openList.isEmpty() && !mappingList.keySet().containsAll(XMLParser.ApplicationsListGUI);
    if (something) {
        // ... Mapping not succesful!
        // answer can't be found
        return false;

    }

    boolean answerFound = openList.isEmpty() && (mappingList.keySet().containsAll(XMLParser.ApplicationsListGUI));
    if (answerFound) {
        // ...
        return true;
    }

    // answer has not been found
    // visit each children
    // order children list by cost
    // ...
    List<GenericTreeNode<String>> childlist = // ...
    Collections.sort(childlist);

    for (int i = 0; i < childlist.size(); i++) {
        inputNode = childlist.get(i);
        // do something
        boolean childHasAnswer = buildTree(inputNode);
        if (childHasAnswer) {
            // answer was found
            return true;
        } // else: our children do not have the answer
    }

    // neither we or our children have the answer, let's go to the parent
    return false;
}