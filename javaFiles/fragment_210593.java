public void levelOrderTraversal()
{
    NodeQueue<BTPosition<E>> queue = new NodeQueue<BTPosition<E>>(); 
    BTPosition<E> current = root;
    queue.enqueue(current); 

    while(!queue.isEmpty())
    {
        current = queue.dequeue();
        System.out.println(temp.element().toString());

        if (current.getLeft() != null)
        {
            queue.enqueue(current.getLeft());
        }
        if (current.getRight() != null)
        {
            queue.enqueue(current.getRight());
        }
    }
}