V get<K, V>(Node<K, V> node, K key)
{
    if(node.is_leaf())
    {
        return node.keys.get(key); // This will either return the value, or null if the key isn't in the leaf and thus not in the tree
    }
    if(key < node.left_key)
    {
        return get(node.left_child, key); // If our key goes to the left, go left recursively
    }
    else if(node.two_node && key <= node.right_key)
    {
        return get(node.center_child, key) // If we have two keys, and we're less than the second one, we go down the center recursively
    }
    else
    {
        return get(node.right_child, key); // If we've gotten here, we know we're going right, go down that path recursively
    }
}