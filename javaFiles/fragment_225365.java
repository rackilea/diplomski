public void remove (String key, BSTNode pos)
    {
        if (pos == null) return;
        if (key.compareTo(pos.key)<0)
            remove (key, pos.leftChild);
        else if (key.compareTo(pos.key)>0)
            remove (key, pos.rightChild);
        else {
            if (pos.leftChild != null && pos.rightChild != null)
            {
                /* pos has two children */
                BSTNode maxFromLeft = findMax (pos.leftChild); //need to make a findMax helper 
                //"Replacing "  pos.key " with " maxFromLeft.key
                pos.key = maxFromLeft.key;
                remove (maxFromLeft.key, pos.leftChild);
            }
            else if(pos.leftChild != null) {
                /* node pointed by pos has at most one child */
                BSTNode trash = pos;
                //"Promoting " pos.leftChild.key " to replace " pos.key
                pos = pos.leftChild;
                trash = null;
            }
            else if(pos.rightChild != null) {
                /* node pointed by pos has at most one child */
                BSTNode trash = pos;
                /* "Promoting " pos.rightChild.key" to replace " pos.key */
                pos = pos.rightChild;
                trash = null;
            }
            else {
                pos = null;
            }
        }
    }