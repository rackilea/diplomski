// local field
Queue queue;

void traverse()
{
    queue = new LinkedListed();
    queue.add(documentRoot);

    queue.add(root);
    while (!queue.isEmpty()) 
    {
        current     = queue.poll();
        children    = current.getChildNodes();

        // the delegate
        process(current);

        for (int i = 0; i < children.getLength(); i++) 
        {
            child = children.item(i);
            switch(child.getNodeType())
            {
            case Node.ELEMENT_NODE:
            case Node.TEXT_NODE:
                queue.add(child);
                break;
            }
        } // end iteration over childnodes
    }
}