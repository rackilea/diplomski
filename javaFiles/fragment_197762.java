for( Iterator<TypedDependency> iter = tdl.iterator(); iter.hasNext(); ) {
    TypedDependency var = iter.next();

    TreeGraphNode dep = var.dep();
    TreeGraphNode gov = var.gov();

    // All useful information for a node in the tree
    String reln = var.reln().getShortName();