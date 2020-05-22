public DefaultMutableTreeNode addNodes(File dir, String filter)
        throws Exception {
    DefaultMutableTreeNode node = new DefaultMutableTreeNode(dir);
    //true iff any subcomponent matches
    boolean matchFound = false;
    for (File file : dir.listFiles()) {

        if (file.isDirectory()) {
            if (file.getName().contains(filter)) {
                matchFound = true;
            } 
            //always call addNodes on directories, because subcomponents may match
            //null return value indicates no match (with Java 8 use Optional for this)
            DefaultMutableTreeNode maybeNode = addNodes(file, filter);
            if(maybeNode != null) {
                matchFound = true;
                node.add(maybeNode);
            }
        } else {
            // apache commons 2.4
            String tmpContent = FileUtils.readFileToString(file);
            if (file.getName().contains(filter)
                    || tmpContent.contains(filter)) {
                matchFound = true;
                log("adding file: " + file.toString());
                node.add(new DefaultMutableTreeNode(file));
            }
        }
    }
    //only return node if node itself or subcomponent matches
    if(matchFound || dir.getName().contains(filter)) {
        return node;
    }
    //return null otherwise
    return null;
}