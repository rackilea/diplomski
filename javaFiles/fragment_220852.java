private DictionaryNode<K, V> curNode = rNode;    
public boolean insert(K key, V value) {
            if (contains(key)) { // if the binary tree contains it don't insert it.
                return false;
            }
            if (rNode == null) { // if the root node is empty, there is nothing in
                                    // the tree
                                    // create a new DictionaryNode.
                rNode = new DictionaryNode<K, V>(key, value);

            } else {// if the above aren't true then you can insert it.

                int c = ((Comparable<K>)key).compareTo(curNode.key);


                if (c < 0) {
                    if (curNode.lChild == null) {
                        curNode.lChild = new DictionaryNode<K, V>(key, value);
                    }
                    else {
                        curNode = curNode.lChild;
                        return insert(key, value);
                    }
                }
                else {
                    if (curNode.rChild == null) {
                        curNode.rChild = new DictionaryNode<K, V>(key, value);
                    }
                    else {
                        curNode = curNode.rChild;
                        return insert(key, value);
                    }
                }

            }
            curNode = rNode;
            changeCounter++;
            currentSize++;
            return true;
        }