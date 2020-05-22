function getChildren(nodeID, listOfNodes):
    childrenList = empty list 
    for each node in listOfNodes:
        if node.parentId == nodeID: // if node is direct child
            node.children = getChildren(node.id, listOfNodes); //recursively get all his children 
            childrenList.add(node) // add it to the children list
    return childrenList;

main:
     listOfNodes = get list from your file
     listOfRoots = init empty list
     for each node in listOfNodes:
         if (node.parentId is empty) //not parent
             listOfRoots.add(node)
     // now listOfRoots is has all the roots
     for each node in listOfRoots:
         node.children = getChildren(node.id, listOfNodes)