boolean isEmpty()
{
    return subProjects.isEmpty() && documents.isEmpty();
}

boolean isChildrenEmpty()
{
    //put before the recursion for speed
    if(!documents.isEmpty()) //check if self has documents
        return false;

    for(Project child : subProjects)
        if(!child.isChildrenEmpty()) //check if any child has documents
            return false;

    return true; //all children + self have no documents
}

boolean toRemove()
{
    if(isEmpty()) //no children, no documents
        return true;

    for(Project child : subProjects)
        if(!child.isChildrenEmpty()) //a child has a document
            return false;
    return true;
}