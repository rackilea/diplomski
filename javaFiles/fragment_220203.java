public Node findNode(String name, Node localTree)
{
...
    // Pre-order - go left
    if(current.leftChild != null)
    {
        System.out.println("going left to " + current.leftChild);
        return findNode(name, current.leftChild); // <===== HERE!
    }
...
}