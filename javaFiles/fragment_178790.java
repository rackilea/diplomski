HierarchicalStreamReader xpp = ...;
    while(xpp.hasMoreChildren()) {
        xpp.moveDown();
        // do something with the child element, and recursive into this again if appropriate
        xpp.moveUp();
    }